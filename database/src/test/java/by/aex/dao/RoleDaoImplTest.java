package by.aex.dao;

import by.aex.entity.Role;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class RoleDaoImplTest extends BaseTest {

    private static final Role ROLE = new Role("user");

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Role")
                .executeUpdate();
    }

    @Test
    public void checkSaveRole() {
        Long id = roleDao.save(ROLE);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindRole() {
        Long id = roleDao.save(ROLE);
        assertNotNull("Id is null", id);

        Role role = roleDao.find(id);
        assertNotNull("Entity is null", role);
    }

    @Test
    public void checkGetUserRole() {
        Long id = roleDao.save(ROLE);
        assertNotNull("Id is null", id);

        Role userRole = roleDao.getUserRole();
        assertNotNull("Entity is null", userRole);
    }

    public static Role getRole() {
        return ROLE;
    }
}
