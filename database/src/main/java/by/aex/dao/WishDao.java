package by.aex.dao;

import by.aex.entity.Wish;

import java.util.List;

public interface WishDao {

    List<Wish> findByBrandAndArticle(String brand, String article);

    List<Wish> findByDescription(String description);
}
