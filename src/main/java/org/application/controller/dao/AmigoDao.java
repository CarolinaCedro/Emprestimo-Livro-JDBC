package org.application.controller.dao;

import org.application.config.ConnectionMySQLDAO;
import org.application.model.AmigoBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmigoDao {

    public static void criarTabelaAmigos() {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS Amigos (" +
                "idAmigo INT AUTO_INCREMENT PRIMARY KEY," +
                "nome VARCHAR(200) NOT NULL," +
                "documento VARCHAR(45)," +
                "status VARCHAR(15)" +
                ")";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.execute();
            System.out.println("Tabela Amigos criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean inserir(AmigoBean amigo) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Amigos (nome, documento, status) VALUES (?, ?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, amigo.getNome());
            psmt.setString(2, amigo.getDocumento());
            psmt.setString(3, amigo.getStatus().toString());
            psmt.executeUpdate();
            return true;
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


    public static boolean atualizar(AmigoBean amigo) {
        System.out.println("como o amigo ta chegando " + amigo);
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Amigos SET nome = ?, documento = ?, status = ? WHERE idAmigo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, amigo.getNome());
            psmt.setString(2, amigo.getDocumento());
            psmt.setString(3, amigo.getStatus());
            psmt.setInt(4, amigo.getIdAmigo());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public static List<AmigoBean> buscarAmigosPorNome(String nome) {
        List<AmigoBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Amigos WHERE nome LIKE ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, "%" + nome + "%"); // Usando LIKE para buscar nomes parcialmente correspondentes
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AmigoBean amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
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




    public static List<AmigoBean> listarTodosOrdenadosPorNomeAsc() {
        List<AmigoBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Amigos WHERE status = 'ATIVO' ORDER BY nome ASC";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AmigoBean amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
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


    public static void excluir(int idAmigo) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Amigos SET status = 'INATIVO' WHERE idAmigo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idAmigo);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<AmigoBean> listarTodos() {
        List<AmigoBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Amigos WHERE status = 'ATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AmigoBean amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
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

    public static List<AmigoBean> listarTodosInativos() {
        List<AmigoBean> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Amigos WHERE status = 'INATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                AmigoBean amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
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



    public static AmigoBean buscarAmigoPorId(int idAmigo) {
        AmigoBean amigo = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Amigos WHERE idAmigo = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idAmigo);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                amigo = new AmigoBean();
                amigo.setIdAmigo(rs.getInt("idAmigo"));
                amigo.setNome(rs.getString("nome"));
                amigo.setDocumento(rs.getString("documento"));
                amigo.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigo;
    }
}
