package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductDao {

    private static final OrderProductDao INSTANCE = new OrderProductDao();

    public static OrderProductDao getInstance() {
        return INSTANCE;
    }
}
