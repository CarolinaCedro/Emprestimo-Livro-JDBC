package org.application.controller.dao;

import org.application.controller.config.ConnectionMySQLDAO;
import org.application.model.AmigoBean;
import org.application.model.EmprestimoBean;
import org.application.model.LivroBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class EmprestimoDao {

    public static void criarTabelasEmprestimos() {
        Connection con = ConnectionMySQLDAO.getConnection();

        // Criar tabela Emprestimos
        String queryEmprestimos = "CREATE TABLE IF NOT EXISTS Emprestimos (" +
                "idEmprestimo INT AUTO_INCREMENT PRIMARY KEY," +
                "dataEmprestimo DATE NOT NULL," +
                "dataDevolucao DATE NOT NULL," +
                "descricao VARCHAR(255) NOT NULL," +
                "idAmigo INT," +
                "status VARCHAR(15) NOT NULL," +
                "FOREIGN KEY (idAmigo) REFERENCES Amigos(idAmigo)" +
                ")";

        // Criar tabela Emprestimo_has_livros
        String queryEmprestimoLivros = "CREATE TABLE IF NOT EXISTS Emprestimo_has_livros (" +
                "idEmprestimo INT," +
                "idLivro INT," +
                "PRIMARY KEY (idEmprestimo, idLivro)," +
                "FOREIGN KEY (idEmprestimo) REFERENCES Emprestimos(idEmprestimo)," +
                "FOREIGN KEY (idLivro) REFERENCES Livros(idLivro)" +
                ")";

        try (PreparedStatement psmtEmprestimos = con.prepareStatement(queryEmprestimos);
             PreparedStatement psmtEmprestimoLivros = con.prepareStatement(queryEmprestimoLivros)) {
            psmtEmprestimos.execute();
            psmtEmprestimoLivros.execute();
            System.out.println("Tabelas Emprestimos e Emprestimo_has_livros criadas com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static EmprestimoBean buscarEmprestimoPorId(int idEmprestimo) {
        EmprestimoBean emprestimo = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Emprestimos WHERE idEmprestimo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEmprestimo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                emprestimo = new EmprestimoBean();
                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setDescricao(rs.getString("descricao"));
                emprestimo.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
                emprestimo.setStatus(rs.getString("status"));
                emprestimo.setListaLivros(buscarLivrosPorEmprestimo(con, idEmprestimo));
                emprestimo.setAmigo(buscarAmigoPorEmprestimo(con, idEmprestimo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("aquiiiiiiiiiii esse clarianaaaa" + emprestimo);
        System.out.println("*******************************");
        System.out.println("*******************************");
        System.out.println("*******************************");
        return emprestimo;
    }


    public static List<EmprestimoBean> listarTodosEmprestimosDetalhados() {
        List<EmprestimoBean> emprestimos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Emprestimos";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                EmprestimoBean emprestimo = new EmprestimoBean();
                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setDescricao(rs.getString("descricao"));
                emprestimo.setDataEmprestimo(rs.getDate("dataEmprestimo"));
                emprestimo.setDataDevolucao(rs.getDate("dataDevolucao"));
                emprestimo.setStatus(rs.getString("status"));

                // Buscar livros associados ao empréstimo
                Set<LivroBean> livros = buscarLivrosPorEmprestimo(con, emprestimo.getIdEmprestimo());
                System.out.println("Aqui a lista de todos os ids que traz no metodo no dao" + livros);
                emprestimo.setListaLivros(livros);

                // Buscar amigo associado ao empréstimo
                AmigoBean amigo = buscarAmigoPorEmpresti(con, emprestimo.getIdEmprestimo());
                emprestimo.setAmigo(amigo);

                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }

    public static AmigoBean buscarAmigoPorEmpresti(Connection con, int idEmprestimo) throws SQLException {
        AmigoBean amigo = null;
        String query = "SELECT Amigos.* FROM Amigos " +
                "INNER JOIN Emprestimos ON Amigos.idAmigo = Emprestimos.idAmigo " +
                "WHERE Emprestimos.idEmprestimo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEmprestimo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
            }
        }
        return amigo;
    }


    public static Set<LivroBean> buscarLivrosPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
        Set<LivroBean> livros = new HashSet<>();
        String query = "SELECT Livros.* FROM Livros " +
                "INNER JOIN Emprestimo_has_livros ON Livros.idLivro = Emprestimo_has_livros.idLivro " +
                "WHERE Emprestimo_has_livros.idEmprestimo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEmprestimo);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                LivroBean livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setStatus(rs.getString("status"));
                // Adicione outros atributos do livro, se necessário
                livros.add(livro);
            }
        }

        return livros;
    }

    public static AmigoBean buscarAmigoPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
        AmigoBean amigo = null;
        String query = "SELECT Amigos.* FROM Amigos " +
                "INNER JOIN Emprestimos ON Amigos.idAmigo = Emprestimos.idAmigo " +
                "WHERE Emprestimos.idEmprestimo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEmprestimo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
            }
        }
        return amigo;
    }



//    public static AmigoBean buscarAmigoPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
//        AmigoBean amigo = null;
//        String query = "SELECT Amigos.* FROM Amigos " +
//                "INNER JOIN Amigos_Emprestimos ON Amigos.idAmigo = Amigos_Emprestimos.idAmigo " +
//                "WHERE Amigos_Emprestimos.idEmprestimo = ?";
//        try (PreparedStatement psmt = con.prepareStatement(query)) {
//            psmt.setInt(1, idEmprestimo);
//            ResultSet rs = psmt.executeQuery();
//            if (rs.next()) {
//                amigo = new AmigoBean();
//                amigo.setIdAmigo(rs.getInt("idAmigo"));
//                amigo.setNome(rs.getString("nome"));
//                amigo.setDocumento(rs.getString("documento"));
//                amigo.setStatus(rs.getString("status"));
//            }
//        }
//        return amigo;
//
//    }


    public static boolean inserirEmprestimo(EmprestimoBean emprestimo) {
        Connection con = ConnectionMySQLDAO.getConnection();

        String queryEmprestimo = "INSERT INTO Emprestimos (dataEmprestimo, dataDevolucao, descricao, idAmigo, status) VALUES (?, ?, ?, ?, ?)";
        String queryEmprestimoLivros = "INSERT INTO Emprestimo_has_livros (idEmprestimo, idLivro) VALUES (?, ?)";

        try (PreparedStatement psmtEmprestimo = con.prepareStatement(queryEmprestimo, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psmtEmprestimoLivros = con.prepareStatement(queryEmprestimoLivros)) {
            con.setAutoCommit(false);

            psmtEmprestimo.setDate(1, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            psmtEmprestimo.setDate(2, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            psmtEmprestimo.setString(3, emprestimo.getDescricao());
            psmtEmprestimo.setInt(4, emprestimo.getAmigo().getIdAmigo());
            psmtEmprestimo.setString(5, emprestimo.getStatus());

            int affectedRows = psmtEmprestimo.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("A inserção do empréstimo falhou, nenhuma linha afetada.");
            }

            try (ResultSet generatedKeys = psmtEmprestimo.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    emprestimo.setIdEmprestimo(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("A inserção do empréstimo falhou, nenhum ID obtido.");
                }
            }

            // Inserir os livros associados ao empréstimo na tabela Emprestimo_has_livros
            for (LivroBean livro : emprestimo.getListaLivros()) {
                psmtEmprestimoLivros.setInt(1, emprestimo.getIdEmprestimo());
                psmtEmprestimoLivros.setInt(2, livro.getIdLivro());
                psmtEmprestimoLivros.addBatch();
            }

            psmtEmprestimoLivros.executeBatch();
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    private static void inserirLivrosEmprestimo(Connection con, EmprestimoBean emprestimo) throws SQLException {
        String query = "INSERT INTO Livros_Emprestimos (idEmprestimo, idLivro) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            for (LivroBean livro : emprestimo.getListaLivros()) {
                psmt.setInt(1, emprestimo.getIdEmprestimo());
                psmt.setInt(2, livro.getIdLivro());
                psmt.addBatch();  // Adicionar a operação ao lote (batch)
            }
            psmt.executeBatch();  // Executar todas as operações do lote
        }
    }

    public static List<EmprestimoBean> buscarLivroPorNome(String filtroNome) {
        List<EmprestimoBean> list = new ArrayList<>();
        System.out.println("filtra por descricação");
        return list;
    }

    public static int getLastInsertedId() {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT LAST_INSERT_ID() as last_id";

        try (PreparedStatement psmt = con.prepareStatement(query)) {
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    int lastId = rs.getInt("last_id");
                    return lastId;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; // Retornar -1 em caso de falha na recuperação do último ID
    }

    public void excluir(Integer id) {
        System.out.println("delete");
    }
}
