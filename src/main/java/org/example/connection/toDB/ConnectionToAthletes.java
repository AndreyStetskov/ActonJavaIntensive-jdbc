package org.example.connection.toDB;

import org.example.connection.ConnectionToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToAthletes implements ConnectionToDB {

    public final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public final String USERNAME = "postgres";
    public final String PASSWORD = "1mperator";

    @Override
    public Connection getConnect() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("It's sad. Connection denied(", e);
        }
    }
}
