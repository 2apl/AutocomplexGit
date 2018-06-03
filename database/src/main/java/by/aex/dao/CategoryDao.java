package by.aex.dao;

import by.aex.entity.Category;

import java.util.List;

public interface CategoryDao extends Dao<Long, Category> {

    List<Category> findByName(String name);
}
