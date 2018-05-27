package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.Product;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductDaoImpl extends BaseDao implements OrderProductDao {

    private static final OrderProductDaoImpl INSTANCE = new OrderProductDaoImpl();

    public List<Order> getOrdersWithProduct(Product product) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select o from OrderProduct o where o.id.product = :product", Order.class)
                    .setParameter("product", product)
                    .list();
        }
    }

    public List<Product> getProductsInOrder(Order order) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select p from OrderProduct p where p.id.order = :order", Product.class)
                    .setParameter("order", order)
                    .list();
        }
    }

    public static OrderProductDaoImpl getInstance() {
        return INSTANCE;
    }
}
