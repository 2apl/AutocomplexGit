package by.aex.dao;

import by.aex.entity.Complex;
import by.aex.entity.Order;
import by.aex.entity.OrderProduct;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class OrderProductDaoImplImplTest extends BaseTest {

    private static final OrderProduct ORDER_PRODUCT = new OrderProduct(new Complex(OrderDaoImplTest.getOrder(), ProductDaoImplTest.getProduct()), 2);

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM OrderProduct")
                    .executeUpdate();
            session.createQuery("DELETE FROM Order ")
                    .executeUpdate();
            session.createQuery("DELETE FROM Product ")
                    .executeUpdate();
            session.save(OrderDaoImplTest.getOrder());
            session.save(ProductDaoImplTest.getProduct());
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveOrderProduct() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(ORDER_PRODUCT);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindOrderProduct() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(ORDER_PRODUCT);
            assertNotNull("Id is null", saved);

            OrderProduct found = session.find(OrderProduct.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }
}