package by.aex.dao;

import by.aex.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findByName(String name);
}
