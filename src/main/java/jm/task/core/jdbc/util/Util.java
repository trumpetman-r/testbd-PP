package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USERNAME = "root_r";
    private static final String DB_PASSWORD = "root_r";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName(DB_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        return connection;
    }

}