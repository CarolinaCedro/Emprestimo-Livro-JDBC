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
                "dataEmprestimo DATE NOT NULL," +
                "dataDevolucao DATE NOT NULL," +
                "descricao VARCHAR(255) NOT NULL," +
                "status VARCHAR(15) NOT NULL" +
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
        return emprestimo;
    }


    public static List<EmprestimoBean> listarTodosEmprestimos() {
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
                emprestimo.setListaLivros(buscarLivrosPorEmprestimo(con, emprestimo.getIdEmprestimo()));
                emprestimo.setAmigo(buscarAmigoPorEmprestimo(con, emprestimo.getIdEmprestimo()));
                emprestimos.add(emprestimo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }


    public static List<LivroBean> buscarLivrosPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
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

    public static AmigoBean buscarAmigoPorEmprestimo(Connection con, int idEmprestimo) throws SQLException {
        AmigoBean amigo = null;
        String query = "SELECT Amigos.* FROM Amigos " +
                "INNER JOIN Amigos_Emprestimos ON Amigos.idAmigo = Amigos_Emprestimos.idAmigo " +
                "WHERE Amigos_Emprestimos.idEmprestimo = ?";
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

    public static void inserirLivrosEmprestimo(EmprestimoBean emprestimo) throws SQLException {
        String query = "INSERT INTO Livros_Emprestimos (idEmprestimo, idLivro) VALUES (?, ?)";
        Connection con = ConnectionMySQLDAO.getConnection();
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            for (LivroBean livro : emprestimo.getListaLivros()) {
                psmt.setInt(1, emprestimo.getIdEmprestimo());
                psmt.setInt(2, livro.getIdLivro());
                psmt.executeUpdate();
            }
        }
    }

    public static void inserirAmigosEmprestimo(Connection con, EmprestimoBean emprestimo) throws SQLException {
        String query = "INSERT INTO Amigos_Emprestimos (idEmprestimo, idAmigo) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            for (AmigoBean amigo : emprestimo.getAmigosQuePegaramLivros()) {
                psmt.setInt(1, emprestimo.getIdEmprestimo());
                psmt.setInt(2, amigo.getIdAmigo());
                psmt.executeUpdate();
            }
        }
    }





}
