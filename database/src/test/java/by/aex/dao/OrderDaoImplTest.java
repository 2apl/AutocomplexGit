package by.aex.dao;

import by.aex.entity.Order;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderDaoImplTest extends BaseTest {

    private static final Order ORDER = new Order(LocalDate.now(), LocalDate.now(), UserDaoImplTest.getUser(), null);
    private static final Long SAVED_USER = UserDaoImpl.getInstance().save(UserDaoImplTest.getUser());

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

    @Test
    public void checkGetAllUsersOrders() {
        Long save = OrderDaoImpl.getInstance().save(ORDER);
        assertNotNull("Id is null", save);

        List<Order> allUsersOrders = OrderDaoImpl.getInstance().getAllUsersOrders(UserDaoImplTest.getUser());
        assertNotNull("Entity is null", allUsersOrders.stream().findFirst().orElse(null));
    }

    @Test
    public void checkGetOrdersBeforeDate() {
        Long save = OrderDaoImpl.getInstance().save(ORDER);
        assertNotNull("Id is null", save);

        List<Order> ordersBeforeDate = OrderDaoImpl.getInstance().getOrdersBeforeDate(LocalDate.now().plusDays(1L));
        assertNotNull("Entity is null", ordersBeforeDate.stream().findFirst().orElse(null));
    }

    @Test
    public void checkGetOrdersAfterDate() {
        Long save = OrderDaoImpl.getInstance().save(ORDER);
        assertNotNull("Id is null", save);

        List<Order> ordersAfterDate = OrderDaoImpl.getInstance().getOrdersAfterDate(LocalDate.now().minusDays(1L));
        assertNotNull("Entity is null", ordersAfterDate.stream().findFirst().orElse(null));
    }

    public static Order getOrder() {
        return ORDER;
    }
}