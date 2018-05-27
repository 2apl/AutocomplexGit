package by.aex.dao;

import by.aex.entity.SearchHistory;

import java.util.List;

public interface SearchHistoryDao {

    List<SearchHistory> findByBrandAndArticle(String brand, String article);

    List<SearchHistory> findByDescription(String description);
}
