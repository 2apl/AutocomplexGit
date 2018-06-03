package by.aex.dao;

import by.aex.entity.SearchHistory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class SearchHistoryDaoImplTest extends BaseTest {

    private static final SearchHistory SEARCH_HISTORY = new SearchHistory("OC100", "Knecht", "Фильтр", UserDaoImplTest.getUser());

    @Autowired
    SearchHistoryDao searchHistoryDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM SearchHistory ")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkSaveSearchHistory() {
        Long id = searchHistoryDao.save(SEARCH_HISTORY);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindSearchHistory() {
        Long id = searchHistoryDao.save(SEARCH_HISTORY);
        assertNotNull("Id is null", id);

        SearchHistory found = searchHistoryDao.find(id);
        assertNotNull("Entity is null", found);
    }

    @Test
    public void checkFindByBrandAndArticle() {
        Long id = searchHistoryDao.save(SEARCH_HISTORY);
        assertNotNull("Id is null", id);

        List<SearchHistory> byBrandAndArticle = searchHistoryDao.findByBrandAndArticle(SEARCH_HISTORY.getBrand(), SEARCH_HISTORY.getArticle());
        assertNotNull("Entity is null", byBrandAndArticle.stream().findFirst().orElse(null));
    }

    @Test
    public void checkFindByDescription() {
        Long id = searchHistoryDao.save(SEARCH_HISTORY);
        assertNotNull("Id is null", id);

        List<SearchHistory> byDescription = searchHistoryDao.findByDescription(SEARCH_HISTORY.getDescription());
        assertNotNull("Entity is null", byDescription.stream().findFirst().orElse(null));
    }
}
