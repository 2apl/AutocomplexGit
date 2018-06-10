package by.aex.dao;

import by.aex.entity.User;

import java.util.List;

public interface UserDao extends Dao<Long, User> {

    User findByEmail(String email);

    List<User> findByLastName(String lastName);
}
