package by.aex.dao;

import by.aex.entity.User;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDaoImpl extends BaseDao<Long, User> implements UserDao {

    private static final UserDaoImpl INSTANCE = new UserDaoImpl();

    public List<User> findByEmail(String email) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select u from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .list();
        }
    }

    public List<User> findByLastName(String lastName) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select u from User u where u.lastName = :lastName", User.class)
                    .setParameter("lastName", lastName)
                    .list();
        }
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }
}
