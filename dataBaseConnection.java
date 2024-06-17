package org.example.assignment1java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Class to manage database connections
public class dataBaseConnection {
    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/video_Game";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method to establish and return a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
