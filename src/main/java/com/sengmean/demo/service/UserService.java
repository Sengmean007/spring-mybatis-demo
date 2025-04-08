package com.sengmean.demo.service;

import com.sengmean.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User update(int id);

    void remove(int id);

    User findById(int id);

    boolean isUserAlreadyPresent(User user);

    List<User> getAllByUsername(String username);

    User findUsername(String username);
}
