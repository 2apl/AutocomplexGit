package by.aex.dao;

import by.aex.entity.Account;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccountDaoImplTest extends BaseTest {

    private static final Account ACCOUNT = new Account(0.0, UserDaoImplTest.getUser());
    private static final Double NUMBER = 12.2;
    private static final Long SAVED_USER = UserDaoImpl.getInstance().save(UserDaoImplTest.getUser());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Account")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveAccount() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(ACCOUNT);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindAccount() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(ACCOUNT);
            assertNotNull("Id is Null", saved);

            Account found = session.find(Account.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkChangeOnNumber() {
        Long save = AccountDaoImpl.getInstance().save(ACCOUNT);
        assertNotNull("Id is null", save);

        AccountDaoImpl.getInstance().changeOnNumber(UserDaoImplTest.getUser(), NUMBER);

        Account account = AccountDaoImpl.getInstance().find(save);
        assertNotNull("Entity is null", account);
        assertEquals(NUMBER, account.getBalance());

    }
}
