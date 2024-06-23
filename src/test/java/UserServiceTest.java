import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {
    private final UserService userService = new UserServiceImpl(new Util());

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 5;

    @Test
    public void dropUsersTable() {
        userService.dropUsersTable();
        userService.dropUsersTable();
    }

    @Test
    public void createUsersTable() {
        userService.dropUsersTable();
        userService.createUsersTable();
    }

    @Test
    public void saveUser() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);

        User user = userService.getAllUsers().get(0);

        Assert.assertEquals("User был некорректно добавлен в базу данных", testName, user.getName());
        Assert.assertEquals("User был некорректно добавлен в базу данных", testLastName, user.getLastName());
        Assert.assertEquals("User был некорректно добавлен в базу данных", testAge, user.getAge().byteValue());
    }

    @Test
    public void removeUserById() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.removeUserById(1L);
    }

    @Test
    public void getAllUsers() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        List<User> userList = userService.getAllUsers();

        Assert.assertEquals("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы", 1, userList.size());
    }

    @Test
    public void cleanUsersTable() {
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        userService.cleanUsersTable();

        Assert.assertEquals("Метод очищения таблицы пользователей реализован не корректно", 0, userService.getAllUsers().size());
    }
}