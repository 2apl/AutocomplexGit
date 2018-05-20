package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.Product;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductDao extends BaseDao {

    private static final OrderProductDao INSTANCE = new OrderProductDao();

    public List<Order> getOrdersWithProduct(Product product) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Order> orderList = session.createQuery("select o from OrderProduct o where o.id.product = :product", Order.class)
                    .setParameter("product", product)
                    .list();
            session.getTransaction().commit();

            return orderList;
        }
    }

    public List<Product> getProductsInOrder(Order order) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from OrderProduct p where p.id.order = :order", Product.class)
                    .setParameter("order", order)
                    .list();
            session.getTransaction().commit();

            return productList;
        }
    }

    public static OrderProductDao getInstance() {
        return INSTANCE;
    }
}
