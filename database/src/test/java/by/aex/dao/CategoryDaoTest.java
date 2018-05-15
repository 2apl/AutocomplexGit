package by.aex.dao;

import by.aex.entity.Category;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class CategoryDaoTest extends BaseTest {

    private static final Category CATEGORY = new Category("Расходники", null);

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Category")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveCategory() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(CATEGORY);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindCategory() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(CATEGORY);
            assertNotNull("Id is null", saved);

            Category found = session.find(Category.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }
}
