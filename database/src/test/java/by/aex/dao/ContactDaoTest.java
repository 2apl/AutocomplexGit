package by.aex.dao;

import by.aex.entity.Contact;
import by.aex.entity.PhoneNumber;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class ContactDaoTest extends BaseTest {

    private static final Contact CONTACT = new Contact(new PhoneNumber("+375297777777"), null, "Минск", "Пушкина", "38", UserDaoTest.getUser());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Contact")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveContact() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(CONTACT);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindContact() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(CONTACT);
            assertNotNull("Id is null", saved);

            Contact found = session.find(Contact.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }
}
