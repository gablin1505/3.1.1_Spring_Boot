package com.example.myfirstspringboot4.daos;

import com.example.myfirstspringboot4.models.User;

import java.util.List;

public interface UserDaoInterface {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);
}