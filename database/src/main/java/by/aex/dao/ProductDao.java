package by.aex.dao;

import by.aex.entity.Product;

import java.util.List;

public interface ProductDao  extends Dao<Long, Product> {

    List<Product> searchByArticle(String article);

    List<Product> searchByArticleAndBrand(String brand, String article);

    List<Product> searchByBrandOrArticleOrDescription(String brand, String article, String description, Integer pageNumber, Integer resultsOnPage);
}
