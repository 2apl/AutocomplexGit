package by.aex.dao;

import by.aex.entity.Category;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDao extends BaseDao<Long, Category> {

    private static final CategoryDao INSTANCE = new CategoryDao();

    public Category findByName(String name) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            Category category = session.createQuery("select c from Category c where c.name = :name", Category.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();

            return category;
        }
    }

    public static CategoryDao getInstance() {
        return INSTANCE;
    }
}
