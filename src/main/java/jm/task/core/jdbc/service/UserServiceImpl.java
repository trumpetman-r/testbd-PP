package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
    private final UserDao userDao;

    public UserServiceImpl() {
        UserDao tempUserDao = null;
        try {
            tempUserDao = new UserDaoJDBCImpl();
        } catch (SQLException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error initializing UserDaoJDBCImpl", e);
        }
        this.userDao = tempUserDao;
    }

    @Override
    public void createUsersTable() {
        try {
            userDao.createUsersTable();
            logger.info("Users table created successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error creating users table", e);
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            userDao.dropUsersTable();
            logger.info("Users table dropped successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error dropping users table", e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            userDao.saveUser(name, lastName, age);
            logger.info("User saved successfully: " + name + " " + lastName);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error saving user", e);
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            userDao.removeUserById(id);
            logger.info("User removed successfully with id: " + id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error removing user", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<User> users = userDao.getAllUsers();
            logger.info("Retrieved all users successfully.");
            return users;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error retrieving all users", e);
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        try {
            userDao.cleanUsersTable();
            logger.info("Users table cleaned successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error cleaning users table", e);
        }
    }
}