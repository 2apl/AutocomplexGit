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
    public List findAll() {
        return null;
    }

    @Override
    public BaseEntity find(Serializable id) {
        return null;
    }

    @Override
    public void update(BaseEntity object) {

    }

    @Override
    public void delete(BaseEntity object) {

    }
}
