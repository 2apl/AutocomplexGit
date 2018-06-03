package by.aex.dao;

import by.aex.entity.Contact;

import java.util.List;

public interface ContactDao extends Dao<Long, Contact> {

    List<Contact> findByPhoneNumber(String phoneNumber);
}
