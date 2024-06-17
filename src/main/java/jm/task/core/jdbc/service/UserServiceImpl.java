package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserHibernateDao;
import jm.task.core.jdbc.dao.UserHibernateDaoImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserHibernateDao userHibernateDao;

    // Конструктор по умолчанию
    public UserServiceImpl() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        this.userHibernateDao = new UserHibernateDaoImpl(hibernateUtil);
    }

    // Конструктор с параметром HibernateUtil для тестирования или других целей
    public UserServiceImpl(HibernateUtil hibernateUtil) {
        this.userHibernateDao = new UserHibernateDaoImpl(hibernateUtil);
    }

    @Override
    public void createUsersTable() {
        userHibernateDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userHibernateDao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userHibernateDao.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userHibernateDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userHibernateDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userHibernateDao.cleanUsersTable();
    }
}
