package by.aex.dao;

import by.aex.entity.User;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao extends BaseDao<Long, User> {

    private static final UserDao INSTANCE = new UserDao();

    public User findByEmail(String email) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            User user = session.createQuery("select u from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
            session.getTransaction().commit();

            return user;
        }
    }

    public List<User> findByLastName(String lastName) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<User> userList = session.createQuery("select u from User u where u.lastName = :lastName", User.class)
                    .setParameter("lastName", lastName)
                    .list();
            session.getTransaction().commit();

            return userList;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
