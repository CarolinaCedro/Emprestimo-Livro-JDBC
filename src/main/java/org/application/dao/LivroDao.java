package org.application.dao;


import org.application.config.ConnectionMySQLDAO;
import org.application.model.LivroBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {


    public static void criarTabelaLivros() {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS Livros (" +
                "idLivro INT AUTO_INCREMENT PRIMARY KEY," +
                "titulo VARCHAR(200) NOT NULL," +
                "status VARCHAR(15)," +
                "editora_id INT," +
                "autor_id INT," +
                "FOREIGN KEY (editora_id) REFERENCES Editoras(idEditora)," +
                "FOREIGN KEY (autor_id) REFERENCES Autores(idAutor)" +
                ")";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.execute();
            System.out.println("Tabela Livros criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void inserir(LivroBean livro) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Livros (titulo, autor_id,editora_id,status) VALUES (?,?,?,?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, livro.getTitulo());
            psmt.setInt(2, livro.getAutor_id());
            psmt.setInt(3, livro.getEditora_id());
            psmt.setString(4, livro.getStatus());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizar(LivroBean livro) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Livros SET titulo = ?, autor_id = ? ,editora_id = ? ,status = ? WHERE idLivro = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, livro.getTitulo());
            psmt.setInt(2, livro.getAutor_id());
            psmt.setInt(3, livro.getEditora_id());
            psmt.setString(4, livro.getStatus());
            psmt.setInt(5, livro.getIdLivro());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluir(int idLivro) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "DELETE FROM Livros WHERE idLivro = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idLivro);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<LivroBean> listarTodas() {
        List<LivroBean> livros = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                LivroBean livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setStatus(rs.getString("status"));
                livro.setAutor_id(rs.getInt("autor_id"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public static LivroBean buscarLivroPorId(int idLivro) {
        LivroBean livro = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros WHERE idLivro = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idLivro);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setStatus(rs.getString("status"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livro.setAutor_id(rs.getInt("autor_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }
}
