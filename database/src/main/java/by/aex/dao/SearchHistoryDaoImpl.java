package by.aex.dao;

import by.aex.entity.SearchHistory;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchHistoryDaoImpl extends BaseDao<Long, SearchHistory> implements SearchHistoryDao {

    private static final SearchHistoryDaoImpl INSTANCE = new SearchHistoryDaoImpl();

    public List<SearchHistory> findByBrandAndArticle(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select s from SearchHistory s where s.brand = :brand and s.article = :article", SearchHistory.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
        }
    }

    public List<SearchHistory> findByDescription(String description) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select s from SearchHistory s where s.description = :description", SearchHistory.class)
                    .setParameter("description", description)
                    .list();
        }
    }

    public static SearchHistoryDaoImpl getInstance() {
        return INSTANCE;
    }
}
