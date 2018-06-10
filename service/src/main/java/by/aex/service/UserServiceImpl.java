package by.aex.service;

import by.aex.converter.UserDetailsConverter;
import by.aex.dao.UserDao;
import by.aex.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserDetailsConverter detailsConverter;


    @Autowired
    public UserServiceImpl(UserDao userDao, UserDetailsConverter detailsConverter) {
        this.userDao = userDao;
        this.detailsConverter = detailsConverter;
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public User find(Long id) {
        return userDao.find(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByLastName(String lastName) {
        return userDao.findByLastName(lastName);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return Optional.of(login)
                .map(userDao::findByEmail)
                .map(detailsConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exist"));
    }
}