package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl() {
        UserDao tempUserDao = null;
        try {
            tempUserDao = new UserDaoJDBCImpl();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.userDao = tempUserDao;
    }

    @Override
    public void createUsersTable() {
        if (userDao != null) {
            userDao.createUsersTable();
        } else {
            System.err.println("UserDao is not initialized.");
        }
    }

    @Override
    public void dropUsersTable() {
        if (userDao != null) {
            userDao.dropUsersTable();
        } else {
            System.err.println("UserDao is not initialized.");
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        if (userDao != null) {
            userDao.saveUser(name, lastName, age);
        } else {
            System.err.println("UserDao is not initialized.");
        }
    }

    @Override
    public void removeUserById(long id) {
        if (userDao != null) {
            userDao.removeUserById(id);
        } else {
            System.err.println("UserDao is not initialized.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        if (userDao != null) {
            return userDao.getAllUsers();
        } else {
            System.err.println("UserDao is not initialized.");
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {
        if (userDao != null) {
            userDao.cleanUsersTable();
        } else {
            System.err.println("UserDao is not initialized.");
        }
    }
}