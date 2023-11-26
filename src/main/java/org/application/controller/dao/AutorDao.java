package org.application.controller.dao;


import org.application.config.ConnectionMySQLDAO;
import org.application.model.AutorBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {


    public static void criarTabelaAutores() {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS Autores (" +
                "idAutor INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(200) NOT NULL," +
                "documento VARCHAR(45)," +
                "status VARCHAR(15)" +
                ")";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.execute();
            System.out.println("Tabela Autores criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean inserir(AutorBean autor) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Autores (nome,documento,status) VALUES (?, ?,?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, autor.getNome());
            psmt.setString(2, autor.getDocumento());
            psmt.setString(3, autor.getStatus());
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

    public static List<AutorBean> buscarAutorPorNome(String nome) {
        List<AutorBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Autores WHERE nome LIKE ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, "%" + nome + "%"); // Usando LIKE para buscar nomes parcialmente correspondentes
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AutorBean amigo = new AutorBean();
                amigo.setIdAutor(rs.getInt("idAutor"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static List<AutorBean> listarTodosInativos() {
        List<AutorBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Autores WHERE status = 'INATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AutorBean amigo = new AutorBean();
                amigo.setIdAutor(rs.getInt("idAutor"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static List<AutorBean> listarTodosOrdenadosPorNomeAsc() {
        List<AutorBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Autores WHERE status = 'ATIVO' ORDER BY nome ASC";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AutorBean amigo = new AutorBean();
                amigo.setIdAutor(rs.getInt("idAutor"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static boolean atualizar(AutorBean autor) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Autores SET nome = ?, status = ? ,documento = ? WHERE idAutor = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, autor.getNome());
            psmt.setString(3, autor.getDocumento());
            psmt.setString(2, autor.getStatus());
            psmt.setInt(4, autor.getIdAutor());
            psmt.executeUpdate();

            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void excluir(int idAutor) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Autores SET status = 'INATIVO' WHERE idAutor = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idAutor);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<AutorBean> listarTodas() {
        List<AutorBean> autors = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Autores WHERE status = 'ATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AutorBean autor = new AutorBean();
                autor.setIdAutor(rs.getInt("idAutor"));
                autor.setStatus(rs.getString("status"));
                autor.setNome(rs.getString("nome"));
                autor.setDocumento(rs.getString("documento"));
                autors.add(autor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autors;
    }

    public static AutorBean buscarAutorPorId(int idAutor) {
        AutorBean autor = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Autores WHERE idAutor = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idAutor);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                autor = new AutorBean();
                autor.setIdAutor(rs.getInt("idAutor"));
                autor.setNome(rs.getString("nome"));
                autor.setDocumento(rs.getString("documento"));
                autor.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autor;
    }
}
