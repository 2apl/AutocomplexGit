package by.aex.dao;

import by.aex.entity.Contact;
import by.aex.entity.PhoneNumber;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

public class ContactDaoImplTest extends BaseTest {

    private static final Contact CONTACT = new Contact(new PhoneNumber("+375297777777"), null, "Минск", "Пушкина", "38", UserDaoImplTest.getUser());

    @Autowired
    private ContactDao contactDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Contact")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkSaveContact() {
        Long id = contactDao.save(CONTACT);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindContact() {
        Long id = contactDao.save(CONTACT);
        assertNotNull("Id is null", id);

        Contact contact = contactDao.find(id);
        assertNotNull("Entity is null", contact);
    }
}
