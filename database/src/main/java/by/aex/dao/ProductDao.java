package by.aex.dao;

import by.aex.entity.Product;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDao extends BaseDao<Long, Product> {

    private static final ProductDao INSTANCE = new ProductDao();

    public List<Product> searchByArticle(String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from Product p where p.article = :article", Product.class)
                    .setParameter("article", article)
                    .list();
            session.getTransaction().commit();

            return productList;
        }
    }

    public List<Product> searchByArticleAndBrand(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from Product p where p.brand = :brand and p.article = :article", Product.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
            session.getTransaction().commit();

            return productList;
        }
    }

    public List<Product> searchByBrandOrArticleOrDescription(String brand, String article, String description, Integer pageNumber, Integer resultsOnPage) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from Product p where p.brand = :brand or p.article = :article or p.description = :description", Product.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .setParameter("description", description)
                    .setFirstResult((resultsOnPage * pageNumber) - resultsOnPage)
                    .setMaxResults(resultsOnPage)
                    .list();
            session.getTransaction().commit();

            return productList;
        }
    }

    public static ProductDao getInstance() {
        return INSTANCE;
    }
}
