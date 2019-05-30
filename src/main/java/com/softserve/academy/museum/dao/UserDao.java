package com.softserve.academy.museum.dao;

import com.softserve.academy.museum.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> list();
}
