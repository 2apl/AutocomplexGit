package by.aex.dao;

import by.aex.entity.Contact;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDao extends BaseDao<Long, Contact> {

    private static final ContactDao INSTANCE = new ContactDao();

    public Contact findByPhoneNumber(String phoneNumber) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            Contact contact = session.createQuery("select c from Contact c where c.phoneNumber = :phoneNumber or c.phoneNumberReserve = :phoneNumber", Contact.class)
                    .setParameter("phoneNumber", phoneNumber)
                    .getSingleResult();
            session.getTransaction().commit();

            return contact;
        }
    }

    public static ContactDao getInstance() {
        return INSTANCE;
    }
}