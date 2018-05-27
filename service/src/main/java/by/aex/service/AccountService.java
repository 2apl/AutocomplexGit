package by.aex.service;

import by.aex.dao.AccountDaoImpl;
import by.aex.entity.Account;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountService {

    private static final AccountService INSTANCE = new AccountService();

    public void save(Account account) {
        AccountDaoImpl.getInstance().save(account);
    }

    public void update(Account account) {
        AccountDaoImpl.getInstance().update(account);
    }

//    public Account getById(User user) {
//        return (Account) AccountDao.getInstance().findById(user);
//    }

    public static AccountService getInstance() {
        return INSTANCE;
    }
}
