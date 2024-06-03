package jm.task.core.jdbc.util;

public class SQLQueries {
    public static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS USER (" +
            "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(50), " +
            "lastName VARCHAR(50), " +
            "age TINYINT)";

    public static final String DROP_USERS_TABLE = "DROP TABLE IF EXISTS USER";

    public static final String INSERT_USER = "INSERT INTO USER (name, lastName, age) VALUES (?, ?, ?)";

    public static final String DELETE_USER_BY_ID = "DELETE FROM USER WHERE id = ?";

    public static final String SELECT_ALL_USERS = "SELECT * FROM USER";

    public static final String TRUNCATE_USERS_TABLE = "TRUNCATE TABLE USER";
}