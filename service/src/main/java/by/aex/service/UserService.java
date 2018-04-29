package by.aex.service;

import by.aex.dao.UserDao;
import by.aex.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public User getDefaultName() {
        return UserDao.getInstance().getDefaultName();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
