package by.aex.dao;

import by.aex.entity.Role;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class RoleDaoTest extends BaseTest {

    private static final Role ROLE = new Role("user");

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM User ")
                    .executeUpdate();
            session.createQuery("DELETE FROM Role")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveRole() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable savedRole = session.save(ROLE);
            assertNotNull("Id is null", savedRole);
        }
    }

    @Test
    public void checkFindRole() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable savedRole = session.save(ROLE);
            assertNotNull("Id is null", savedRole);

            Role role = session.find(Role.class, savedRole);
            assertNotNull("Entity is null", role);
            session.getTransaction().commit();
        }
    }

    public static Role getRole() {
        return ROLE;
    }
}
