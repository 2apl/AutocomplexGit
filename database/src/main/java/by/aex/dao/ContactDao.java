package by.aex.dao;

import by.aex.entity.Contact;

import java.util.List;

public interface ContactDao {

    List<Contact> findByPhoneNumber(String phoneNumber);
}
