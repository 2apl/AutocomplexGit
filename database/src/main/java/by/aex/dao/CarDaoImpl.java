package by.aex.dao;

import by.aex.entity.Car;
import by.aex.util.SessionFactoryUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarDaoImpl extends BaseDao<Long, Car> implements CarDao {

    private static final CarDaoImpl INSTANCE = new CarDaoImpl();

    public Car findByVin(String vin) {
        try (Session session = SessionFactoryUtil.getFactory().openSession()) {
            return session.createQuery("select c from Car c where c.vin = :vin", Car.class)
                    .setParameter("vin", vin)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);
        }
    }

    public static CarDaoImpl getInstance() {
        return INSTANCE;
    }
}
