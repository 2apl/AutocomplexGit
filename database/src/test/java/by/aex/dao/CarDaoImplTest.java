package by.aex.dao;

import by.aex.entity.Car;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarDaoImplTest extends BaseTest {

    private static final Car CAR = new Car("Audi", "A5", 2018, "VIN", UserDaoImplTest.getUser());

    @Autowired
    private CarDao carDao;

    @Before
    public void before() {
        sessionFactory.getCurrentSession()
                .createQuery("DELETE FROM Car")
                .executeUpdate();
        roleDao.save(RoleDaoImplTest.getRole());
        userDao.save(UserDaoImplTest.getUser());
    }

    @Test
    public void checkSaveCar() {
        Long id = carDao.save(CAR);
        assertNotNull("Id is null", id);
    }

    @Test
    public void checkFindCar() {
        Long id = carDao.save(CAR);
        assertNotNull("Id is null", id);

        Car car = carDao.find(id);
        assertNotNull("Entity is null", car);
    }

    @Test
    public void checkFindByVin() {
        Long id = carDao.save(CAR);
        assertNotNull("Id is null", id);

        Car car = carDao.findByVin(CAR.getVin());
        assertNotNull("Entity is null", car);
        assertEquals(CAR.getVin(), car.getVin());
    }
}
