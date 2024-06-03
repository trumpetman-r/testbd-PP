package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USERNAME = "root_r";
    private static final String DB_PASSWORD = "root_r";

    public static Connection getConnection() throws RuntimeException {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create the database connection", e);
        }
        return connection;
    }
}