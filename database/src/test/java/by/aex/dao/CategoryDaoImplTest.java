package by.aex.dao;

import by.aex.entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class CategoryDaoImplTest extends BaseTest {

    private static final Category CATEGORY = new Category("Расходники", null);

    @Autowired
    private CategoryDao categoryDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Category")
                .executeUpdate();
    }

    @Test
    public void checkSaveCategory() {
        Long id = categoryDao.save(CATEGORY);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindCategory() {
        Long id = categoryDao.save(CATEGORY);
        assertNotNull("Id is null", id);

        Category found = categoryDao.find(id);
        assertNotNull("Entity is null", found);
    }

    @Test
    public void checkFindByName() {
        Long id = categoryDao.save(CATEGORY);
        assertNotNull("Id is null", id);

        List<Category> byName = categoryDao.findByName(CATEGORY.getName());
        assertNotNull("Entity is null", byName.stream().findFirst().orElse(null));
    }
}
