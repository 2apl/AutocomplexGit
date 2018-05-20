package by.aex.dao;

import by.aex.entity.Role;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDao extends BaseDao<Long, Role> {

    private static final RoleDao INSTANCE = new RoleDao();

    public Role getUserRole() {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            Role role = session.createQuery("select r from Role r where r.name = :user", Role.class)
                    .setParameter("user", "user")
                    .uniqueResult();
            session.getTransaction().commit();

            return role;
        }
    }

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
