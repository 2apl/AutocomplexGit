package by.aex.dao;

import by.aex.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends BaseDao<Long, Category> implements CategoryDao {

    public List<Category> findByName(String name) {
        return sessionFactory.getCurrentSession().createQuery("select c from Category c where c.name = :name", Category.class)
                .setParameter("name", name)
                .getResultList();
    }
}
