package com.softserve.academy.museum.service;

import com.softserve.academy.museum.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    List<User> list();
}