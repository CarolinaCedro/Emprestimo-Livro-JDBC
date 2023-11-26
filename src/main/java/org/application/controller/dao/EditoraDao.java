package org.application.controller.dao;


import org.application.config.ConnectionMySQLDAO;
import org.application.model.EditoraBEAN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EditoraDao {

    public static void criarTabelaEditoras() {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "CREATE TABLE IF NOT EXISTS Editoras (" +
                "idEditora INT AUTO_INCREMENT PRIMARY KEY," +
                "razaoSocial VARCHAR(45) NOT NULL," +
                "status VARCHAR(15)" +
                ")";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.execute();
            System.out.println("Tabela Editoras criada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean inserir(EditoraBEAN editora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "INSERT INTO Editoras (razaoSocial, status) VALUES (?, ?)";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, editora.getRazaoSocial());
            psmt.setString(2, editora.getStatus());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean atualizar(EditoraBEAN editora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Editoras SET razaoSocial = ?, status = ? WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, editora.getRazaoSocial());
            psmt.setString(2, editora.getStatus());
            psmt.setInt(3, editora.getIdEditora());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void excluir(int idEditora) {
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "UPDATE Editoras SET status = 'INATIVO' WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEditora);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static EditoraBEAN buscarEditoraPorId(int idEditora) {
        EditoraBEAN editora = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEditora);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                editora = new EditoraBEAN();
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setRazaoSocial(rs.getString("razaoSocial"));
                editora.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editora;
    }

    public static List<EditoraBEAN> buscarAmigosPorNome(String razao) {
        List<EditoraBEAN> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras WHERE razaoSocial LIKE ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setString(1, "%" + razao + "%"); // Usando LIKE para buscar nomes parcialmente correspondentes
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                EditoraBEAN amigo = new EditoraBEAN();
                amigo.setIdEditora(rs.getInt("idEditora"));
                amigo.setRazaoSocial(rs.getString("razaoSocial"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static List<EditoraBEAN> listarTodosInativos() {
        List<EditoraBEAN> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras WHERE status = 'INATIVO'";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                EditoraBEAN amigo = new EditoraBEAN();
                amigo.setIdEditora(rs.getInt("idEditora"));
                amigo.setRazaoSocial(rs.getString("razaoSocial"));
                amigo.setStatus(rs.getString("status"));
                amigos.add(amigo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static List<EditoraBEAN> listarTodosOrdenadosPorNomeAsc() {
        List<EditoraBEAN> amigos = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras WHERE status = 'ATIVO' ORDER BY razaoSocial ASC";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                EditoraBEAN editora = new EditoraBEAN();
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setRazaoSocial(rs.getString("razaoSocial"));
                editora.setStatus(rs.getString("status"));
                amigos.add(editora);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return amigos;
    }

    public static List<EditoraBEAN> listarTodas() {
        List<EditoraBEAN> editoras = new ArrayList<>();
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras  WHERE status = 'ATIVO'";
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

    public static EditoraBEAN buscarAutorPorId(int idEditora) {
        EditoraBEAN editora = null;
        Connection con = ConnectionMySQLDAO.getConnection();
        String query = "SELECT * FROM Editoras WHERE idEditora = ?";
        try (PreparedStatement psmt = con.prepareStatement(query)) {
            psmt.setInt(1, idEditora);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                editora = new EditoraBEAN();
                editora.setIdEditora(rs.getInt("idEditora"));
                editora.setRazaoSocial(rs.getString("razaoSocial"));
                editora.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editora;
    }
}
