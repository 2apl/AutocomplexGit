package by.aex.dao;

import by.aex.entity.Wish;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishDaoImpl extends BaseDao<Long, Wish> implements WishDao {

    public List<Wish> findByBrandAndArticle(String brand, String article) {
        return sessionFactory.getCurrentSession().createQuery("select w from Wish w where w.brand = :brand and w.article = :article", Wish.class)
                .setParameter("brand", brand)
                .setParameter("article", article)
                .list();
    }

    public List<Wish> findByDescription(String description) {
        return sessionFactory.getCurrentSession().createQuery("select w from Wish w where w.description = :description", Wish.class)
                .setParameter("description", description)
                .list();
    }
}
