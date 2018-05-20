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
public class OrderDao extends BaseDao<Long, Order> {

    private static final OrderDao INSTANCE = new OrderDao();

    public List<Order> getAllUsersOrders(User user) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Order> orderList = session.createQuery("select o from Order o where o.user = :user", Order.class)
                    .setParameter("user", user)
                    .list();
            session.getTransaction().commit();

            return orderList;
        }
    }

    public List<Order> getOrdersBeforeDate(LocalDate date) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Order> orderList = session.createQuery("select o from Order o where o.dateStart < :date", Order.class)
                    .setParameter("date", date)
                    .list();
            session.getTransaction().commit();

            return orderList;
        }
    }

    public List<Order> getOrdersAfterDate(LocalDate date) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Order> orderList = session.createQuery("select o from Order o where o.dateStart > :date", Order.class)
                    .setParameter("date", date)
                    .list();
            session.getTransaction().commit();

            return orderList;
        }
    }

    public static OrderDao getInstance() {
        return INSTANCE;
    }
}
