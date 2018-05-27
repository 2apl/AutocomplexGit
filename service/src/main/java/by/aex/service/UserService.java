package by.aex.service;

import by.aex.dao.UserDaoImpl;
import by.aex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDaoImpl userDaoImpl;

    @Autowired
    public UserService(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void save(User user) {
        UserDaoImpl.getInstance().save(user);
    }

    public void update(User user) {
        UserDaoImpl.getInstance().update(user);
    }

    public void delete(User user) {
        UserDaoImpl.getInstance().delete(user);
    }

//    public User findById(User user) {
//        return (User) UserDao.getInstance().findById(user);
//    }
}