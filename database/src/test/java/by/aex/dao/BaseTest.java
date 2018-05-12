package by.aex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

    private static SessionFactory factory;

    @BeforeClass
    public static void load() {
        factory = new Configuration().configure().buildSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(RoleDaoTest.getRole());
            session.save(UserDaoTest.getUser());
            session.getTransaction().commit();
        }
    }

    @AfterClass
    public static void after() {
        factory.close();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
