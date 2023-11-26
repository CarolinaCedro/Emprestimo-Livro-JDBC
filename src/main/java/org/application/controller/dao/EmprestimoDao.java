package org.application.controller.dao;

import org.application.config.ConnectionMySQLDAO;
import org.application.model.AmigoBean;
import org.application.model.EmprestimoBean;
import org.application.model.LivroBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {

    public static void criarTabelaEmprestimos() {
        Connection con = ConnectionMySQLDAO.getConnection();

        // Criar tabela Emprestimos
        String queryEmprestimos = "CREATE TABLE IF NOT EXISTS Emprestimos (" +
                "idEmprestimo INT AUTO_INCREMENT PRIMARY KEY," +
                "data DATE NOT NULL," +
                "situacao VARCHAR(15) NOT NULL" +
                ")";

        // Criar tabela Livros_Emprestimos
        String queryLivrosEmprestimos = "CREATE TABLE IF NOT EXISTS Livros_Emprestimos (" +
                "idEmprestimo INT," +
                "idLivro INT," +
                "FOREIGN KEY (idEmprestimo) REFERENCES Emprestimos(idEmprestimo)," +
                "FOREIGN KEY (idLivro) REFERENCES Livros(idLivro)," +
                "PRIMARY KEY (idEmprestimo, idLivro)" +
                ")";

        // Criar tabela Amigos_Emprestimos
        String queryAmigosEmprestimos = "CREATE TABLE IF NOT EXISTS Amigos_Emprestimos (" +
                "idEmprestimo INT," +
                "idAmigo INT," +
                "FOREIGN KEY (idEmprestimo) REFERENCES Emprestimos(idEmprestimo)," +
                "FOREIGN KEY (idAmigo) REFERENCES Amigos(idAmigo)," +
                "PRIMARY KEY (idEmprestimo, idAmigo)" +
                ")";

        try (PreparedStatement psmtEmprestimos = con.prepareStatement(queryEmprestimos);
             PreparedStatement psmtLivrosEmprestimos = con.prepareStatement(queryLivrosEmprestimos);
             PreparedStatement psmtAmigosEmprestimos = con.prepareStatement(queryAmigosEmprestimos)) {
            psmtEmprestimos.execute();
            psmtLivrosEmprestimos.execute();
            psmtAmigosEmprestimos.execute();
            System.out.println("Tabelas Emprestimos, Livros_Emprestimos e Amigos_Emprestimos criadas com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static boolean inserir(EmprestimoBean emprestimo) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Emprestimos (data, situacao) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            psmt.setDate(1, new java.sql.Date(emprestimo.getData().getTime()));
            psmt.setString(2, emprestimo.getSituacao());
            psmt.executeUpdate();

            ResultSet generatedKeys = psmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                emprestimo.setIdEmprestimo(generatedKeys.getInt(1));
            }

            // Relacionamento muitos para muitos: Livros
            inserirLivrosEmprestimo(con, emprestimo);

            // Relacionamento muitos para muitos: Amigos
            inserirAmigosEmprestimo(con, emprestimo);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void inserirLivrosEmprestimo(Connection con, EmprestimoBean emprestimo) throws SQLException {
        String query = "INSERT INTO Livros_Emprestimos (idEmprestimo, idLivro) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            for (LivroBean livro : emprestimo.getLivrosEmprestados()) {
                psmt.setInt(1, emprestimo.getIdEmprestimo());
                psmt.setInt(2, livro.getIdLivro());
                psmt.executeUpdate();
            }
        }
    }

    private static void inserirAmigosEmprestimo(Connection con, EmprestimoBean emprestimo) throws SQLException {
        String query = "INSERT INTO Amigos_Emprestimos (idEmprestimo, idAmigo) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            for (AmigoBean amigo : emprestimo.getAmigosQuePegaramLivros()) {
                psmt.setInt(1, emprestimo.getIdEmprestimo());
                psmt.setInt(2, amigo.getIdAmigo());
                psmt.executeUpdate();
            }
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
                emprestimo.setData(rs.getDate("data"));
                emprestimo.setSituacao(rs.getString("situacao"));

                // Buscar livros relacionados ao empréstimo
                emprestimo.setLivrosEmprestados(buscarLivrosPorEmprestimo(con, idEmprestimo));

                // Buscar amigos relacionados ao empréstimo
                emprestimo.setAmigosQuePegaramLivros(buscarAmigosPorEmprestimo(con, idEmprestimo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimo;
    }

    private static List<LivroBean> buscarLivrosPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
        List<LivroBean> livros = new ArrayList<>();
        String query = "SELECT Livros.* FROM Livros " +
                "INNER JOIN Livros_Emprestimos ON Livros.idLivro = Livros_Emprestimos.idLivro " +
                "WHERE Livros_Emprestimos.idEmprestimo = ?";
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

    private static List<AmigoBean> buscarAmigosPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
        List<AmigoBean> amigos = new ArrayList<>();
        String query = "SELECT Amigos.* FROM Amigos " +
                "INNER JOIN Amigos_Emprestimos ON Amigos.idAmigo = Amigos_Emprestimos.idAmigo " +
                "WHERE Amigos_Emprestimos.idEmprestimo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEmprestimo);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AmigoBean amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }
}
