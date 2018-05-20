package by.aex.dao;

import by.aex.entity.SearchHistory;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class SearchHistoryDaoTest extends BaseTest {

    private static final SearchHistory SEARCH_HISTORY = new SearchHistory("OC100", "Knecht", "Фильтр", UserDaoTest.getUser());
    private static final Long SAVED_USER = UserDao.getInstance().save(UserDaoTest.getUser());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM SearchHistory ")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveSearchHistory() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(SEARCH_HISTORY);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindSearchHistory() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(SEARCH_HISTORY);
            assertNotNull("Id is null", saved);

            SearchHistory found = session.find(SearchHistory.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkFindByBrandAndArticle() {
        SearchHistoryDao.getInstance().save(SEARCH_HISTORY);
        SearchHistoryDao.getInstance().findByBrandAndArticle("Knecht", "OC100");
    }

    @Test
    public void checkFindByDescription() {
        SearchHistoryDao.getInstance().save(SEARCH_HISTORY);
        SearchHistoryDao.getInstance().findByDescription("Фильтр");
    }
}
