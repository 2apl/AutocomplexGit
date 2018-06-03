package by.aex.dao;

import by.aex.entity.Account;
import by.aex.entity.User;

public interface AccountDao extends Dao<Long, Account> {

    void changeOnNumber(User user, Double number);
}
