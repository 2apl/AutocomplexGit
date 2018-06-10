package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderDaoImpl extends BaseDao<Long, Order> implements OrderDao {

    public List<Order> getAllUsersOrders(User user) {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.user = :user", Order.class)
                .setParameter("user", user)
                .list();
    }


    public List<Order> getOrdersBeforeDate(LocalDate date) {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.dateStart < :date", Order.class)
                .setParameter("date", date)
                .list();
    }

    public List<Order> getOrdersAfterDate(LocalDate date) {
        return sessionFactory.getCurrentSession().createQuery("select o from Order o where o.dateStart > :date", Order.class)
                .setParameter("date", date)
                .list();
    }
}
