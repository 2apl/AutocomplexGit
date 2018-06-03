package by.aex.dao;

import by.aex.entity.Order;
import by.aex.entity.OrderProduct;
import by.aex.entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class OrderProductDaoImpl implements OrderProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Order> getOrdersWithProduct(Product product) {
        return sessionFactory.getCurrentSession().createQuery("select o from OrderProduct o where o.id.product = :product", Order.class)
                .setParameter("product", product.getId())
                .list();
    }

    public List<Product> getProductsInOrder(Order order) {
        return sessionFactory.getCurrentSession().createQuery("select p from OrderProduct p where p.id.order = :order", Product.class)
                .setParameter("order", order)
                .list();
    }

    public Serializable save(OrderProduct orderProduct) {
        return sessionFactory.getCurrentSession().save(orderProduct);
    }

    public List<OrderProduct> findAll() {
        return sessionFactory.getCurrentSession().createQuery("select o from OrderProduct o", OrderProduct.class)
                .list();
    }

    public OrderProduct find(Serializable id) {
        return sessionFactory.getCurrentSession().find(OrderProduct.class, id);
    }

    public void update(OrderProduct orderProduct) {
        sessionFactory.getCurrentSession().update(orderProduct);
    }

    public void delete(OrderProduct orderProduct) {
        sessionFactory.getCurrentSession().delete(orderProduct);
    }
}
