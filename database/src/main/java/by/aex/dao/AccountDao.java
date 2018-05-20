package by.aex.dao;

import by.aex.entity.Account;
import by.aex.entity.User;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDao extends BaseDao<Long, Account> {

    private static final AccountDao INSTANCE = new AccountDao();

    public void changeOnNumber(User user, Double number) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("update Account a set a.balance = a.balance + :number where a.user = :user")
                    .setParameter("number", number)
                    .setParameter("user", user)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public static AccountDao getInstance() {
        return INSTANCE;
    }
}
