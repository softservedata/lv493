package com.softserve.edu.greencity.rest.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDatabase {
    public static final String NAME = "postgres";
    public static final String PASSWORD = "Lv493-TAQC";
    public static final String URL = "jdbc:postgresql://localhost/greencity";

    private Connection connection;

    public Statement createStatement() throws SQLException {
        if (connection == null) {
            connection  = DriverManager.getConnection(URL, NAME, PASSWORD);
            return connection.createStatement();
        }
        return connection.createStatement();
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }
}
