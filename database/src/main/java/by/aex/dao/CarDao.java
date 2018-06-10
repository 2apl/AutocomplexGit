package by.aex.dao;

import by.aex.entity.Car;

public interface CarDao extends Dao<Long, Car> {

    Car findByVin(String vin);
}
