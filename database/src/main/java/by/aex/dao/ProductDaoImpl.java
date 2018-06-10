package by.aex.dao;

import by.aex.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl extends BaseDao<Long, Product> implements ProductDao {

    public List<Product> searchByArticle(String article) {
        return sessionFactory.getCurrentSession().createQuery("select p from Product p where p.article = :article", Product.class)
                .setParameter("article", article)
                .list();
    }

    public List<Product> searchByArticleAndBrand(String brand, String article) {
        return sessionFactory.getCurrentSession().createQuery("select p from Product p where p.brand = :brand and p.article = :article", Product.class)
                .setParameter("brand", brand)
                .setParameter("article", article)
                .list();
    }

    public List<Product> searchByBrandOrArticleOrDescription(String brand, String article, String description, Integer pageNumber, Integer resultsOnPage) {
        return sessionFactory.getCurrentSession()
                .createQuery("select p from Product p where (:brand is null or p.brand = :brand) and (:article is null or p.article = :article) and (:description is null or p.description = :description)", Product.class)
                .setParameter("brand", brand)
                .setParameter("article", article)
                .setParameter("description", description)
                .setFirstResult((resultsOnPage * pageNumber) - resultsOnPage)
                .setMaxResults(resultsOnPage)
                .list();
    }
}
