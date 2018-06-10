package by.aex.dao;

import by.aex.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDao<Long, Role> implements RoleDao {

    public Role getUserRole() {
        return sessionFactory.getCurrentSession().createQuery("select r from Role r where r.name = :user", Role.class)
                .setParameter("user", "user")
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
