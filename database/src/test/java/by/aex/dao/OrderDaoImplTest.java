package by.aex.dao;

import by.aex.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderDaoImplTest extends BaseTest {

    private static final Order ORDER = new Order(LocalDate.now(), LocalDate.now(), UserDaoImplTest.getUser(), null);

    @Autowired
    OrderDao orderDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Order ")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkSaveOrder() {
        Long id = orderDao.save(ORDER);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindOrder() {
        Long id = orderDao.save(ORDER);
        assertNotNull("Id is null", id);

        Order ord = orderDao.find(id);
        assertNotNull("Entity is null", ord);
    }

    @Test
    public void checkGetAllUsersOrders() {
        Long id = orderDao.save(ORDER);
        assertNotNull("Id is null", id);

        List<Order> allUsersOrders = orderDao.getAllUsersOrders(UserDaoImplTest.getUser());
        assertNotNull("Entity is null", allUsersOrders.stream().findFirst().orElse(null));
    }

    @Test
    public void checkGetOrdersBeforeDate() {
        Long id = orderDao.save(ORDER);
        assertNotNull("Id is null", id);

        List<Order> ordersBeforeDate = orderDao.getOrdersBeforeDate(LocalDate.now().plusDays(1L));
        assertNotNull("Entity is null", ordersBeforeDate.stream().findFirst().orElse(null));
    }

    @Test
    public void checkGetOrdersAfterDate() {
        Long id = orderDao.save(ORDER);
        assertNotNull("Id is null", id);

        List<Order> ordersAfterDate = orderDao.getOrdersAfterDate(LocalDate.now().minusDays(1L));
        assertNotNull("Entity is null", ordersAfterDate.stream().findFirst().orElse(null));
    }

    public static Order getOrder() {
        return ORDER;
    }
}