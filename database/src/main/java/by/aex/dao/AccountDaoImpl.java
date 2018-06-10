package by.aex.dao;

import by.aex.entity.Account;
import by.aex.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends BaseDao<Long, Account> implements AccountDao {

    public void changeOnNumber(User user, Double number) {
        sessionFactory.getCurrentSession().createQuery("update Account a set a.balance = a.balance + :number where a.user = :user")
                .setParameter("number", number)
                .setParameter("user", user)
                .executeUpdate();
    }
}
