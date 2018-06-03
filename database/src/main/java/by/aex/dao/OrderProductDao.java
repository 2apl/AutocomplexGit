package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.OrderProduct;
import by.aex.entity.Product;

import java.io.Serializable;
import java.util.List;

public interface OrderProductDao {

    List<Order> getOrdersWithProduct(Product product);

    List<Product> getProductsInOrder(Order order);

    Serializable save(OrderProduct orderProduct);

    List<OrderProduct> findAll();

    OrderProduct find(Serializable id);

    void update(OrderProduct orderProduct);

    void delete(OrderProduct orderProduct);
}
