package by.aex.dao;

import by.aex.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ProductDaoImplTest extends BaseTest {

    private static final Product PRODUCT = new Product("111", "ATE", "колодки", null, 122.20, null);

    @Autowired
    private ProductDao productDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Product ")
                .executeUpdate();
    }

    @Test
    public void checkSaveProduct() {
        Long id = productDao.save(PRODUCT);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindProduct() {
        Long id = productDao.save(PRODUCT);
        assertNotNull("Id is null", id);

        Product product = productDao.find(id);
        assertNotNull("Entity is null", product);
    }

    @Test
    public void checkSearchByArticle() {
        Long id = productDao.save(PRODUCT);
        assertNotNull("Id is null", id);

        List<Product> productList = productDao.searchByArticle(PRODUCT.getArticle());
        assertNotNull("Entity is null", productList.stream().findFirst().orElse(null));
    }

    @Test
    public void checkSearchByArticleAndBrand() {
        Long id = productDao.save(PRODUCT);
        assertNotNull("Id is null", id);

        List<Product> productList = productDao.searchByArticleAndBrand(PRODUCT.getBrand(), PRODUCT.getArticle());
        assertNotNull("Entity is null", productList.stream().findFirst().orElse(null));
    }

    @Test
    public void checkSearchByBrandOrArticleOrDescription() {
        Long id = productDao.save(PRODUCT);
        assertNotNull("Id is null", id);

        List<Product> productList = productDao.searchByBrandOrArticleOrDescription(PRODUCT.getBrand(), PRODUCT.getArticle(), PRODUCT.getDescription(), 1, 10);
        assertNotNull("Entity is null", productList.stream().findFirst().orElse(null));
    }

    public static Product getProduct() {
        return PRODUCT;
    }
}