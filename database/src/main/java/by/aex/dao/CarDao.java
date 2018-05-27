package by.aex.dao;

import by.aex.entity.Car;

public interface CarDao {

    Car findByVin(String vin);
}
