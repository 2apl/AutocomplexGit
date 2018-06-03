package by.aex.dao;

import by.aex.config.DaoConfiguration;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DaoConfiguration.class)
@Transactional
public class BaseTest {

    @Autowired
    protected RoleDao roleDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected SessionFactory sessionFactory;
}
