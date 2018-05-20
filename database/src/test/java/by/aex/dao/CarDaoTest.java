package by.aex.dao;

import by.aex.entity.Car;
import by.aex.entity.User;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class CarDaoTest extends BaseTest {

    private static final Car CAR = new Car("Audi", "A5", 2018, "VIN", UserDaoTest.getUser());
    private static final Long SAVED_USER = UserDao.getInstance().save(UserDaoTest.getUser());

    @Before
    public void clean() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Car")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkSaveCar() {
        try (Session session = BaseTest.getFactory().openSession()) {
            Serializable save = session.save(CAR);
            assertNotNull("Id is null", save);
        }
    }

    @Test
    public void checkFindCar() {
        try (Session session = BaseTest.getFactory().openSession()) {
            session.beginTransaction();
            Serializable saved = session.save(CAR);
            assertNotNull("Id is null", saved);

            Car found = session.find(Car.class, saved);
            assertNotNull("Entity is null", found);
            session.getTransaction().commit();
        }
    }

    @Test
    public void checkFindByVin() {
        CarDao.getInstance().save(CAR);
        CarDao.getInstance().findByVin("VIN");
    }

    @Test
    public void checkSave() {
        CarDao.getInstance().save(CAR);
    }
}
