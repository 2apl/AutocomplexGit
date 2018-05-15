package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ContactDao {

    private static final ContactDao INSTANCE = new ContactDao();

    public static ContactDao getInstance() {
        return INSTANCE;
    }
}