package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDao {

    private static final CarDao INSTANCE = new CarDao();

    public static CarDao getInstance() {
        return INSTANCE;
    }
}
