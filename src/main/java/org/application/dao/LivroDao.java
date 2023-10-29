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


    public static boolean inserir(LivroBean livro) {
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
        return false;
    }

    public static boolean atualizar(LivroBean livro) {
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
        return false;
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

    public static LivroBean buscarAmigoPorId(int idAmigo) {
        LivroBean livro = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros WHERE idLivro = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idAmigo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livro.setAutor_id(rs.getInt("autor_id"));
                livro.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livro;
    }


    public static List<LivroBean> listarTodosOrdenadosPorNomeAsc() {
        List<LivroBean> livros = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros WHERE status = 'ATIVO' ORDER BY titulo ASC";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                LivroBean livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livro.setAutor_id(rs.getInt("autor_id"));
                livro.setStatus(rs.getString("status"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public static void excluir(int idLivro) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Livros SET status = 'INATIVO' WHERE idLivro = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idLivro);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<LivroBean> listarTodosInativos() {
        System.out.println("chegou aqui");
        List<LivroBean> livros = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros WHERE status = 'INATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                LivroBean livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livro.setAutor_id(rs.getInt("autor_id"));
                livro.setStatus(rs.getString("status"));
                livros.add(livro);
                System.out.println("o livro" + livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public static List<LivroBean> buscarLivroPorNome(String titulo) {
        List<LivroBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Livros WHERE titulo LIKE ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, "%" + titulo + "%"); // Usando LIKE para buscar nomes parcialmente correspondentes
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                LivroBean livro = new LivroBean();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setEditora_id(rs.getInt("editora_id"));
                livro.setAutor_id(rs.getInt("autor_id"));
                livro.setStatus(rs.getString("status"));
                amigos.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
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
