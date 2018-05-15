package by.aex.dao;

import by.aex.entity.Product;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class ProductDaoTest extends BaseTest {

    private static final Product PRODUCT = new Product("111", "ATE", "колодки", null, 122.20, null);

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Product ")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveProduct() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(PRODUCT);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindProduct() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(PRODUCT);
            assertNotNull("Id is null", saved);

            Product found = session.find(Product.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    public static Product getProduct() {
        return PRODUCT;
    }
}