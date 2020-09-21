package com.sengmean.demo.service;

import com.sengmean.demo.model.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    List<Users> save(List<Users> users);

    Users update(int id);

    void deleteById(Integer id);

    Users findById(int id);

    boolean isUserAlreadyPresent(Users user);

    List<Users> getAllByUsername(String username);
}
