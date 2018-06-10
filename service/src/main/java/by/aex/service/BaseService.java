package by.aex.service;

import by.aex.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService <PK extends Serializable, T extends BaseEntity<PK>> {

    PK save(T object);

    List<T> findAll();

    T find(PK id);

    void update(T object);

    void delete(T object);
}
