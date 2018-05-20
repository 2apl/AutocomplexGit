package by.aex.service;

import by.aex.dao.AccountDao;
import by.aex.entity.Account;
import by.aex.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountService {

    private static final AccountService INSTANCE = new AccountService();

    public void save(Account account) {
        AccountDao.getInstance().save(account);
    }

    public void update(Account account) {
        AccountDao.getInstance().update(account);
    }

//    public Account getById(User user) {
//        return (Account) AccountDao.getInstance().findById(user);
//    }

    public static AccountService getInstance() {
        return INSTANCE;
    }
}
