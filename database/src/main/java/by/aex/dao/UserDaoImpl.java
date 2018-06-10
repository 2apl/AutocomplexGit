package by.aex.dao;

import by.aex.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDao<Long, User> implements UserDao {

    public List<User> findByEmail(String email) {
        return sessionFactory.getCurrentSession().createQuery("select u from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .list();
    }

    public List<User> findByLastName(String lastName) {
        return sessionFactory.getCurrentSession().createQuery("select u from User u where u.lastName = :lastName", User.class)
                .setParameter("lastName", lastName)
                .list();
    }
}
