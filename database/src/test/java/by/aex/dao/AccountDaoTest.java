package by.aex.dao;

import by.aex.entity.Account;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class AccountDaoTest extends BaseTest {

    private static final Account ACCOUNT = new Account(0.0, UserDaoTest.getUser());

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
            AccountDao.getInstance().changeOnNumber(UserDaoTest.getUser(), 12.35);
    }
}
