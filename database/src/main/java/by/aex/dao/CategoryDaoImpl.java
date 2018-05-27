package by.aex.dao;

import by.aex.entity.Category;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDaoImpl extends BaseDao<Long, Category> implements CategoryDao {

    private static final CategoryDaoImpl INSTANCE = new CategoryDaoImpl();

    public List<Category> findByName(String name) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select c from Category c where c.name = :name", Category.class)
                    .setParameter("name", name)
                    .getResultList();
        }
    }

    public static CategoryDaoImpl getInstance() {
        return INSTANCE;
    }
}
