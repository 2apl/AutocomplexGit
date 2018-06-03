package by.aex.service;

import by.aex.dao.UserDao;
import by.aex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User find(Long id) {
        return userDao.find(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public List<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByLastName(String lastName) {
        return userDao.findByLastName(lastName);
    }
}