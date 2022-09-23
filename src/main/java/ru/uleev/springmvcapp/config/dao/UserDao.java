package ru.uleev.springmvcapp.config.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.uleev.springmvcapp.config.model.User;

import java.util.List;

@Component
public class UserDao {


    private final SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users=session.createQuery("select p from User p", User.class)
                .getResultList();

        return users;

    }

    public User show(int id) {

        return null;
    }

    public void save(User user) {

    }

    public void update(int id, User updateUser) {

    }

    public void delete(int id) {

    }

}
