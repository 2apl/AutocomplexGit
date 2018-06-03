package by.aex.dao;

import by.aex.entity.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDaoImplTest extends BaseTest {

    private static final User USER = new User("Ivan", "Ivanov", "email", "password");

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM User ")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
    }

    @Test
    public void checkSaveUser() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindUser() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        User user = userDao.find(id);
        assertNotNull("Entity is null", user);
    }

    @Test
    public void checkSave() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkUpdate() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        USER.setFirstName("Petr");
        userDao.update(USER);

        String firstName = userDao.find(id).getFirstName();
        assertEquals("Petr", firstName);
    }

    @Test
    public void checkDelete() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        userDao.delete(USER);

        User user = userDao.find(id);
        assertNull("User not deleted", user);
    }

    @Test
    public void checkFind() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        User user = userDao.find(id);
        assertNotNull("Entity is null", user);
    }

    @Test
    public void checkFindAll() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        List<User> allUsers = userDao.findAll();
        assertNotNull("No found users", allUsers.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByEmail() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        List<User> byEmail = userDao.findByEmail(USER.getEmail());
        assertNotNull("No found users", byEmail.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByLastName() {
        Long id = userDao.save(USER);
        assertNotNull("Id is null", id);

        List<User> byLastName = userDao.findByLastName(USER.getLastName());
        assertNotNull("No found users", byLastName.stream().findFirst().orElse(null));
    }


    public static User getUser() {
        return USER;
    }
}
