package by.aex.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDao {

    private static final AccountDao INSTANCE = new AccountDao();

    public static AccountDao getInstance() {
        return INSTANCE;
    }
}
