package by.aex.dao;

import by.aex.entity.Role;

public interface RoleDao extends Dao<Long, Role> {

    Role getUserRole();
}
