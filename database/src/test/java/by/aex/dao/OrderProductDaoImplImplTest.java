package by.aex.dao;

import by.aex.entity.Complex;
import by.aex.entity.OrderProduct;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class OrderProductDaoImplImplTest extends BaseTest {

    private static final OrderProduct ORDER_PRODUCT = new OrderProduct(new Complex(OrderDaoImplTest.getOrder(), ProductDaoImplTest.getProduct()), 2);

    @Autowired
    private OrderProductDao orderProductDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Before
    public void before() {
            sessionFactory.getCurrentSession()
                    .createQuery("DELETE FROM OrderProduct")
                    .executeUpdate();
            sessionFactory.getCurrentSession()
                    .createQuery("DELETE FROM Order ")
                    .executeUpdate();
            sessionFactory.getCurrentSession()
                    .createQuery("DELETE FROM Product ")
                    .executeUpdate();
            roleDao.save(RoleDaoImplTest.getRole());
            userDao.save(UserDaoImplTest.getUser());
            orderDao.save(OrderDaoImplTest.getOrder());
            productDao.save(ProductDaoImplTest.getProduct());
    }

    @Test
    public void checkSaveOrderProduct() {
        Serializable save = orderProductDao.save(ORDER_PRODUCT);
        assertNotNull("Id is null", save);
    }

    @Test
    public void checkFindOrderProduct() {
        Serializable id = orderProductDao.save(ORDER_PRODUCT);
        assertNotNull("Id is null", id);

        OrderProduct orderProduct = orderProductDao.find(id);
        assertNotNull("Entity is null", orderProduct);
    }
}