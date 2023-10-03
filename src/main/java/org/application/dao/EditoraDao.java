package org.application.dao;


import org.application.config.ConnectionMySQLDAO;
import org.application.model.EditoraBEAN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditoraDao {
    // Método para inserir uma editora no banco de dados.
    public static void inserir(EditoraBEAN editora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Editora (razaoSocial, status) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, editora.getRazaoSocial());
            psmt.setString(2, editora.getStatus());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar uma editora no banco de dados.
    public static void atualizar(EditoraBEAN editora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Editora SET razaoSocial = ?, status = ? WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, editora.getRazaoSocial());
            psmt.setString(2, editora.getStatus());
            psmt.setInt(3, editora.getIdEditora());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir uma editora do banco de dados.
    public static void excluir(int idEditora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "DELETE FROM Editora WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEditora);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obter todas as editoras do banco de dados.
    public static List<EditoraBEAN> listarTodas() {
        List<EditoraBEAN> editoras = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editora";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                EditoraBEAN editora = new EditoraBEAN();
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setRazaoSocial(rs.getString("razaoSocial"));
                editora.setStatus(rs.getString("status"));
                editoras.add(editora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editoras;
    }
}
