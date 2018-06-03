package by.aex.dao;

import by.aex.entity.Wish;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class WishDaoImplTest extends BaseTest {

    private static final Wish WISH = new Wish("OC100", "Knecht", "Фильтр", UserDaoImplTest.getUser(), 10);

    @Autowired
    WishDao wishDao;

    @Before
    public void clean() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Wish ")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkSaveWish() {
        Long id = wishDao.save(WISH);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindWish() {
        Long id = wishDao.save(WISH);
        assertNotNull("Id is null", id);

        Wish wish = wishDao.find(id);
        assertNotNull("Entity is null", wish);
    }

    @Test
    public void checkFindByBrandAndArticle() {
        Long id = wishDao.save(WISH);
        assertNotNull("Id is null", id);

        List<Wish> byBrandAndArticle = wishDao.findByBrandAndArticle(WISH.getBrand(), WISH.getArticle());
        assertNotNull("Entity is null", byBrandAndArticle.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByDescription() {
        Long id = wishDao.save(WISH);
        assertNotNull("Id is null", id);

        List<Wish> byDescription = wishDao.findByDescription(WISH.getDescription());
        assertNotNull("Entity is null", byDescription.stream().findFirst().orElse(null));
    }
}
