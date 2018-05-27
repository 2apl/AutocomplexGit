package by.aex.dao;

import by.aex.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findByEmail(String email);

    List<User> findByLastName(String lastName);


}
