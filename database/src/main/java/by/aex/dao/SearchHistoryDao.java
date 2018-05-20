package by.aex.dao;

import by.aex.entity.SearchHistory;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchHistoryDao extends BaseDao<Long, SearchHistory> {

    private static final SearchHistoryDao INSTANCE = new SearchHistoryDao();

    public List<SearchHistory> findByBrandAndArticle(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<SearchHistory> searchHistoryList = session.createQuery("select s from SearchHistory s where s.brand = :brand and s.article = :article", SearchHistory.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
            session.getTransaction().commit();

            return searchHistoryList;
        }
    }

    public List<SearchHistory> findByDescription(String description) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<SearchHistory> searchHistoryList = session.createQuery("select s from SearchHistory s where s.description = :description", SearchHistory.class)
                    .setParameter("description", description)
                    .list();
            session.getTransaction().commit();

            return searchHistoryList;
        }
    }

    public static SearchHistoryDao getInstance() {
        return INSTANCE;
    }
}
