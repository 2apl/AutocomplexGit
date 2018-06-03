package by.aex.dao;

import by.aex.entity.SearchHistory;

import java.util.List;

public interface SearchHistoryDao extends Dao<Long, SearchHistory> {

    List<SearchHistory> findByBrandAndArticle(String brand, String article);

    List<SearchHistory> findByDescription(String description);
}
