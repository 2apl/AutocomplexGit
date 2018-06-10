package by.aex.dao;

import by.aex.entity.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.io.Serializable;
import java.util.List;

public class BaseDao<PK extends Serializable, T extends BaseEntity<PK>> implements Dao<PK, T> {

    @Autowired
    protected SessionFactory sessionFactory;
    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDao() {
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDao.class)[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public PK save(T object) {
        return (PK) sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public T find(PK id) {
        return sessionFactory.getCurrentSession().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery(String.format("select o from %s o", clazz.getSimpleName()), clazz)
                .list();
    }

    @Override
    public void update(T object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }
}
