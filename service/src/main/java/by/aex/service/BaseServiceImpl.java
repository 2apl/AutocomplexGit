package by.aex.service;

import by.aex.dao.BaseDao;
import by.aex.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl <T extends BaseDao> implements BaseService {

    private final T baseDao;

    public BaseServiceImpl(T baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public Serializable save(BaseEntity object) {
        return baseDao.save(object);
    }

    @Override
    public List<T> findAll() {
        return baseDao.findAll();
    }

    @Override
    public BaseEntity find(Serializable id) {
        return baseDao.find(id);
    }

    @Override
    public void update(BaseEntity object) {
        baseDao.update(object);
    }

    @Override
    public void delete(BaseEntity object) {
        baseDao.delete(object);
    }
}
