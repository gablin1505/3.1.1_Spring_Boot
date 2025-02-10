package com.example.myfirstspringboot4.services;

import com.example.myfirstspringboot4.daos.UserDao;
import com.example.myfirstspringboot4.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements UserInterface {
    private final UserDao userDAO;

    @Autowired
    public UserService(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public User show(int id) {
        return userDAO.show(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void update(int id, User user) {
        userDAO.update(id, user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
