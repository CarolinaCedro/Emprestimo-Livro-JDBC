package org.application.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionMySQLDAO {
    // Constantes para o driver JDBC, URL do banco de dados e credenciais de acesso.
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/mysql-facul";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    // A conexão é armazenada como um membro estático para ser reutilizada.
    private static Connection con;

    // Bloco estático para carregar o driver JDBC quando a classe é carregada.
    static {
        try {
            Class.forName(DRIVER);
            // Inicialmente, abra a conexão quando a classe for carregada.
            con = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obter a conexão com o banco de dados.
    public static Connection getConnection() {
        System.out.println("Conexão com o banco bem sucedida !");
        return con;
    }

    // Método para executar uma consulta SQL e retornar um ResultSet.
    public static ResultSet getResultSet(String query, Object... parametros) {
        PreparedStatement psmt;
        ResultSet rs = null;
        try {
            psmt = con.prepareStatement(query);
            for (int i = 0; i < parametros.length; i++) {
                psmt.setObject(i + 1, parametros[i]);
            }
            rs = psmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Método para executar uma consulta SQL e retornar o ID gerado, se houver.
    public static long executeQuery(String query, Object... parametros) {
        long update = 0;
        try (PreparedStatement psmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            for (int i = 0; i < parametros.length; i++) {
                psmt.setObject(i + 1, parametros[i]);
            }
            psmt.execute();
            ResultSet rs = psmt.getGeneratedKeys();
            if (rs != null && rs.next()) {
                update = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
