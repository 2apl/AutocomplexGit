package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryDao {

    private static final CategoryDao INSTANCE = new CategoryDao();

    public static CategoryDao getInstance() {
        return INSTANCE;
    }
}
