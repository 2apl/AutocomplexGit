package by.aex.dao;

import by.aex.entity.Order;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

public class OrderDaoTest extends BaseTest {

    private static final Order ORDER = new Order(LocalDate.now(), LocalDate.now(), UserDaoTest.getUser(), null);

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Order ")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveOrder() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(ORDER);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindOrder() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(ORDER);
            assertNotNull("Id is null", saved);

            Order found = session.find(Order.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    public static Order getOrder() {
        return ORDER;
    }
}