package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.User;

import java.time.LocalDate;
import java.util.List;

public interface OrderDao extends Dao<Long, Order> {

    List<Order> getAllUsersOrders(User user);

    List<Order> getOrdersBeforeDate(LocalDate date);

    List<Order> getOrdersAfterDate(LocalDate date);
}
