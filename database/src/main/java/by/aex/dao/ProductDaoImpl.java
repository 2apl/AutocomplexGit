package by.aex.dao;

import by.aex.entity.Product;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDaoImpl extends BaseDao<Long, Product> implements ProductDao {

    private static final ProductDaoImpl INSTANCE = new ProductDaoImpl();

    public List<Product> searchByArticle(String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select p from Product p where p.article = :article", Product.class)
                    .setParameter("article", article)
                    .list();
        }
    }

    public List<Product> searchByArticleAndBrand(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select p from Product p where p.brand = :brand and p.article = :article", Product.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
        }
    }

    public List<Product> searchByBrandOrArticleOrDescription(String brand, String article, String description, Integer pageNumber, Integer resultsOnPage) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select p from Product p where p.brand = :brand or p.article = :article or p.description = :description", Product.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .setParameter("description", description)
                    .setFirstResult((resultsOnPage * pageNumber) - resultsOnPage)
                    .setMaxResults(resultsOnPage)
                    .list();
        }
    }

    public static ProductDaoImpl getInstance() {
        return INSTANCE;
    }
}
