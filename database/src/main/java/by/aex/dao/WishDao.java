package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WishDao {

    private static final WishDao INSTANCE = new WishDao();

    public static WishDao getInstance() {
        return INSTANCE;
    }
}
