package by.aex.dao;

import by.aex.entity.SearchHistory;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SearchHistoryDaoImplTest extends BaseTest {

    private static final SearchHistory SEARCH_HISTORY = new SearchHistory("OC100", "Knecht", "Фильтр", UserDaoImplTest.getUser());
    private static final Long SAVED_USER = UserDaoImpl.getInstance().save(UserDaoImplTest.getUser());

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
        Long save = SearchHistoryDaoImpl.getInstance().save(SEARCH_HISTORY);
        assertNotNull("Id is null", save);

        List<SearchHistory> byBrandAndArticle = SearchHistoryDaoImpl.getInstance().findByBrandAndArticle(SEARCH_HISTORY.getBrand(), SEARCH_HISTORY.getArticle());
        assertNotNull("Entity is null", byBrandAndArticle.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByDescription() {
        Long save = SearchHistoryDaoImpl.getInstance().save(SEARCH_HISTORY);
        assertNotNull("Id is null", save);

        List<SearchHistory> byDescription = SearchHistoryDaoImpl.getInstance().findByDescription(SEARCH_HISTORY.getDescription());
        assertNotNull("Entity is null", byDescription.stream().findFirst().orElse(null));
    }
}
