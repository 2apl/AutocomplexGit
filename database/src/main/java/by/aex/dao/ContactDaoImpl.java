package by.aex.dao;

import by.aex.entity.Contact;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDaoImpl extends BaseDao<Long, Contact> implements ContactDao {

    private static final ContactDaoImpl INSTANCE = new ContactDaoImpl();

    public List<Contact> findByPhoneNumber(String phoneNumber) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select c from Contact c where c.phoneNumber = :phoneNumber", Contact.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getResultList();
        }
    }

    public static ContactDaoImpl getInstance() {
        return INSTANCE;
    }
}