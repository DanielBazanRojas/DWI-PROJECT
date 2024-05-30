package com.turismPage.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String jdbcURL = "jdbc:postgresql://localhost:5432/turismBD";
    private String jdbcUsername = "postgres";
    private String jdbcPassword = "tremendo";
    private Connection jdbcConnection;

    public Connection getConnection() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("org.postgresql.Driver");
                jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new SQLException(e);
            }
        }
        return jdbcConnection;
    }
}
