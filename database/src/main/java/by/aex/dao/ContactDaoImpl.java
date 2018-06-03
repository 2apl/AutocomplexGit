package by.aex.dao;

import by.aex.entity.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl extends BaseDao<Long, Contact> implements ContactDao {

    public List<Contact> findByPhoneNumber(String phoneNumber) {
        return sessionFactory.getCurrentSession().createQuery("select c from Contact c where c.phoneNumber = :phoneNumber", Contact.class)
                .setParameter("phoneNumber", phoneNumber)
                .getResultList();
    }
}