package by.aex.dao;

import by.aex.entity.Wish;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WishDao extends BaseDao<Long, Wish> {

    private static final WishDao INSTANCE = new WishDao();

    public List<Wish> findByBrandAndArticle(String brand, String article) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Wish> wishList = session.createQuery("select w from Wish w where w.brand = :brand and w.article = :article", Wish.class)
                    .setParameter("brand", brand)
                    .setParameter("article", article)
                    .list();
            session.getTransaction().commit();

            return wishList;
        }
    }

    public List<Wish> findByDescription(String description) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Wish> wishList = session.createQuery("select w from Wish w where w.description = :description", Wish.class)
                    .setParameter("description", description)
                    .list();
            session.getTransaction().commit();

            return wishList;
        }
    }

    public static WishDao getInstance() {
        return INSTANCE;
    }
}
