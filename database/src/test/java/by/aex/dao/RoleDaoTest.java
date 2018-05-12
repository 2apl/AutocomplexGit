package by.aex.dao;

import by.aex.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class RoleDaoTest {

    private static final Role ROLE = new Role("user");

    private static SessionFactory factory;

    @BeforeClass
    public static void load() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    @AfterClass
    public static void after() {
        factory.close();
    }

    @Before
    public void clean() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Role")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveRole() {
        try (Session session = factory.openSession()) {
            Serializable savedRole = session.save(ROLE);
            assertNotNull("Id is null", savedRole);
        }
    }

    @Test
    public void checkFindRole() {
        try (Session session = factory.openSession()) {
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
