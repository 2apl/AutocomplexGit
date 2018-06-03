package by.aex.dao;

import by.aex.entity.SearchHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchHistoryDaoImpl extends BaseDao<Long, SearchHistory> implements SearchHistoryDao {

    public List<SearchHistory> findByBrandAndArticle(String brand, String article) {
        return sessionFactory.getCurrentSession().createQuery("select s from SearchHistory s where s.brand = :brand and s.article = :article", SearchHistory.class)
                .setParameter("brand", brand)
                .setParameter("article", article)
                .list();
    }

    public List<SearchHistory> findByDescription(String description) {
        return sessionFactory.getCurrentSession().createQuery("select s from SearchHistory s where s.description = :description", SearchHistory.class)
                .setParameter("description", description)
                .list();

    }
}
