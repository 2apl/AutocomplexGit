package by.aex.dao;

import by.aex.entity.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserDaoImplTest extends BaseTest {

    private static final User USER = new User("Ivan", "Ivanov", "email", "password");

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User ")
                    .executeUpdate();
            session.save(RoleDaoImplTest.getRole());
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveUser() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable userId = session.save(USER);
            assertNotNull("Id is null", userId);
        }
    }

    @Test
    public void checkFindUser() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable userId = session.save(USER);
            assertNotNull("Id is null", userId);

            User user = session.find(User.class, userId);
            assertNotNull("Entity is null", user);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSave() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);
    }

    @Test
    public void checkUpdate() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        USER.setFirstName("Petr");
        UserDaoImpl.getInstance().update(USER);

        String firstName = UserDaoImpl.getInstance().find(save).getFirstName();
        assertEquals("Petr", firstName);
    }

    @Test
    public void checkDelete() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        UserDaoImpl.getInstance().delete(USER);

        User user = UserDaoImpl.getInstance().find(save);
        assertNull("User not deleted", user);
    }

    @Test
    public void checkFind() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        User user = UserDaoImpl.getInstance().find(save);
        assertNotNull("Entity is null", user);
    }

    @Test
    public void checkFindAll() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        List<User> allUsers = UserDaoImpl.getInstance().findAll();
        assertNotNull("No found users", allUsers.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByEmail() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        List<User> byEmail = UserDaoImpl.getInstance().findByEmail(USER.getEmail());
        assertNotNull("No found users", byEmail.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByLastName() {
        Long save = UserDaoImpl.getInstance().save(USER);
        assertNotNull("Id is null", save);

        List<User> byLastName = UserDaoImpl.getInstance().findByLastName(USER.getLastName());
        assertNotNull("No found users", byLastName.stream().findFirst().orElse(null));
    }


    public static User getUser() {
        return USER;
    }
}
