package by.aex.dao;

import by.aex.entity.Wish;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WishDaoImpl extends BaseDao<Long, Wish> implements WishDao {

    private static final WishDaoImpl INSTANCE = new WishDaoImpl();

    public List<Wish> findByBrandAndArticle(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select w from Wish w where w.brand = :brand and w.article = :article", Wish.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
        }
    }

    public List<Wish> findByDescription(String description) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select w from Wish w where w.description = :description", Wish.class)
                    .setParameter("description", description)
                    .list();
        }
    }

    public static WishDaoImpl getInstance() {
        return INSTANCE;
    }
}
