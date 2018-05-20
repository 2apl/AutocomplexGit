package by.aex.dao;

import by.aex.entity.Wish;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class WishDaoTest extends BaseTest {

    private static final Wish WISH = new Wish("OC100", "Knecht", "Фильтр", UserDaoTest.getUser(), 10);
    private static final Long SAVED_USER = UserDao.getInstance().save(UserDaoTest.getUser());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Wish ")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveWish() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(WISH);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindWish() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(WISH);
            assertNotNull("Id is null", saved);

            Wish found = session.find(Wish.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkFindByBrandAndArticle() {
        WishDao.getInstance().save(WISH);
        WishDao.getInstance().findByBrandAndArticle("Knecht", "OC100");
    }

    @Test
    public void checkFindByDescription() {
        WishDao.getInstance().save(WISH);
        WishDao.getInstance().findByDescription("Фильтр");
    }
}
