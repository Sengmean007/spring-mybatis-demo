package com.sengmean.demo.service;

import com.sengmean.demo.model.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users save(Users users);

    void update(int id);

    void deleteById(Integer id);

    Users findByUsername(String username);

    Users findById(int id);
}
