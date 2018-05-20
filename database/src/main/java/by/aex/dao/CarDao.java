package by.aex.dao;

import by.aex.entity.Car;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDao extends BaseDao<Long, Car> {

    private static final CarDao INSTANCE = new CarDao();

    public Car findByVin(String vin) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            session.beginTransaction();
            Car car = session.createQuery("select c from Car c where c.vin = :vin", Car.class)
                    .setParameter("vin", vin)
                    .uniqueResult();
            session.getTransaction().commit();

            return car;
        }
    }

    public static CarDao getInstance() {
        return INSTANCE;
    }
}
