package org.application.dao;

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

    public static void inserir(AmigoBean amigo) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Amigos (nome, documento, status) VALUES (?, ?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, amigo.getNome());
            psmt.setString(2, amigo.getDocumento());
            psmt.setString(3, amigo.getStatus());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizar(AmigoBean amigo) {
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
    }

    public static void excluir(int idAmigo) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "DELETE FROM Amigos WHERE idAmigo = ?";
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
        String query = "SELECT * FROM Amigos";
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
