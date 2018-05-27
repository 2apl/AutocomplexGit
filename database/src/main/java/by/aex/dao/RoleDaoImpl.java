package by.aex.dao;

import by.aex.entity.Role;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDaoImpl extends BaseDao<Long, Role> implements RoleDao {

    private static final RoleDaoImpl INSTANCE = new RoleDaoImpl();

    public Role getUserRole() {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select r from Role r where r.name = :user", Role.class)
                    .setParameter("user", "user")
                    .list()
                    .get(0);
        }
    }

    public static RoleDaoImpl getInstance() {
        return INSTANCE;
    }
}
