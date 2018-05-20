package by.aex.service;

import by.aex.dao.RoleDao;
import by.aex.dao.UserDao;
import by.aex.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public void save(User user) {
        UserDao.getInstance().save(user);
    }

    public void update(User user) {
        UserDao.getInstance().update(user);
    }

    public void delete(User user) {
        UserDao.getInstance().delete(user);
    }

//    public User findById(User user) {
//        return (User) UserDao.getInstance().findById(user);
//    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
