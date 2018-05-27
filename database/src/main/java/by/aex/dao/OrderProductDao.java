package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.Product;

import java.util.List;

public interface OrderProductDao {

    List<Order> getOrdersWithProduct(Product product);

    List<Product> getProductsInOrder(Order order);
}
