package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoleDao {

    private static final RoleDao INSTANCE = new RoleDao();

    public static RoleDao getInstance() {
        return INSTANCE;
    }
}
