package by.aex.dao;

import by.aex.entity.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class UserDaoTest extends BaseTest {

    private static final User USER = new User("Ivan", "Ivanov", "email", "password");

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

    @Test
    public void checkSave() {
        UserDao.getInstance().save(USER);
    }

    @Test
    public void checkUpdate() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().update(USER);
    }

    @Test
    public void checkDelete() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().delete(USER);
    }

    @Test
    public void checkFind() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().find(USER.getId());
    }

    @Test
    public void checkFindAll() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().findAll();
    }

    @Test
    public void checkFindByEmail() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().findByEmail("email");
    }

    @Test
    public void checkFindByLastName() {
        UserDao.getInstance().save(USER);
        UserDao.getInstance().findByLastName("Ivanov");
    }


    public static User getUser() {
        return USER;
    }
}
