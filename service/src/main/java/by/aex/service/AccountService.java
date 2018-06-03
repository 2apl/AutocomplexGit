package by.aex.service;

import by.aex.dao.AccountDao;
import by.aex.entity.Account;
import by.aex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Account account) {
        accountDao.delete(account);
    }

    public Account find(Long id) {
        return accountDao.find(id);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void changeOnNumber(User user, Double number) {
        accountDao.changeOnNumber(user, number);
    }
}
