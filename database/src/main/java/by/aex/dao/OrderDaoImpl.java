package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.User;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderDaoImpl extends BaseDao<Long, Order> implements OrderDao {

    private static final OrderDaoImpl INSTANCE = new OrderDaoImpl();

    public List<Order> getAllUsersOrders(User user) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select o from Order o where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .list();
        }
    }

    public List<Order> getOrdersBeforeDate(LocalDate date) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select o from Order o where o.dateStart < :date", Order.class)
                    .setParameter("date", date)
                    .list();
        }
    }

    public List<Order> getOrdersAfterDate(LocalDate date) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select o from Order o where o.dateStart > :date", Order.class)
                    .setParameter("date", date)
                    .list();
        }
    }

    public static OrderDaoImpl getInstance() {
        return INSTANCE;
    }
}
