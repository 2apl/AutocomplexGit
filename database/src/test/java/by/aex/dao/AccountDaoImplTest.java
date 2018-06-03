package by.aex.dao;

import by.aex.entity.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountDaoImplTest extends BaseTest {

    @Autowired
    private AccountDao accountDao;

    private static final Account ACCOUNT = new Account(0.0, UserDaoImplTest.getUser());
    private static final Double NUMBER = 12.2;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Account")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkExisting() {
        assertNotNull("Spring context is not loaded", accountDao);
    }

    @Test
    public void checkSaveAccount() {
        Long id = accountDao.save(ACCOUNT);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindAccount() {
        Long id = accountDao.save(ACCOUNT);
        assertNotNull("Id is Null", id);

        Account account = accountDao.find(id);
        assertNotNull("Entity is null", account);
    }

    @Test
    public void checkChangeOnNumber() {
        Long id = accountDao.save(ACCOUNT);
        assertNotNull("Id is null", id);

        accountDao.changeOnNumber(UserDaoImplTest.getUser(), NUMBER);
        sessionFactory.getCurrentSession().clear();

        Account account = accountDao.find(id);
        assertNotNull("Entity is null", account);
        assertEquals(NUMBER, account.getBalance());
    }
}
