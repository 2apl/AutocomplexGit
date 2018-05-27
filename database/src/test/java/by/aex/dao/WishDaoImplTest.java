package by.aex.dao;

import by.aex.entity.Wish;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class WishDaoImplTest extends BaseTest {

    private static final Wish WISH = new Wish("OC100", "Knecht", "Фильтр", UserDaoImplTest.getUser(), 10);
    private static final Long SAVED_USER = UserDaoImpl.getInstance().save(UserDaoImplTest.getUser());

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
        Long save = WishDaoImpl.getInstance().save(WISH);
        assertNotNull("Id is null", save);

        List<Wish> byBrandAndArticle = WishDaoImpl.getInstance().findByBrandAndArticle(WISH.getBrand(), WISH.getArticle());
        assertNotNull("Entity is null", byBrandAndArticle.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByDescription() {
        Long save = WishDaoImpl.getInstance().save(WISH);
        assertNotNull("Id is null", save);

        List<Wish> byDescription = WishDaoImpl.getInstance().findByDescription(WISH.getDescription());
        assertNotNull("Entity is null", byDescription.stream().findFirst().orElse(null));
    }
}
