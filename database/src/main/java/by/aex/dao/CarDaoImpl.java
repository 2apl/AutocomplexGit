package by.aex.dao;

import by.aex.entity.Car;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl extends BaseDao<Long, Car> implements CarDao {

    public Car findByVin(String vin) {
        return sessionFactory.getCurrentSession().createQuery("select c from Car c where c.vin = :vin", Car.class)
                .setParameter("vin", vin)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
