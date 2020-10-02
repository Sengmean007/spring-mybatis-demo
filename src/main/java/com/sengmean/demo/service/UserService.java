package com.sengmean.demo.service;

import com.sengmean.demo.model.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    void save(Users user);

    Users update(int id);

    void deleteById(Integer id);

    Users findById(int id);

    boolean isUserAlreadyPresent(Users user);

    List<Users> getAllByUsername(String username);
}
