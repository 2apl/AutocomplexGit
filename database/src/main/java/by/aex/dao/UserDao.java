package by.aex.dao;

import by.aex.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    public User getDefaultName() {
        return new User();
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
