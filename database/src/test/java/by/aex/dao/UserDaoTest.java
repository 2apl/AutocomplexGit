package by.aex.dao;

import by.aex.entity.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UserDaoTest extends BaseTest {

    private static final User USER = new User("Ivan", "Ivanov", "email", "password", RoleDaoTest.getRole());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User ")
                    .executeUpdate();
            session.save(RoleDaoTest.getRole());
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

    public static User getUser() {
        return USER;
    }
}
