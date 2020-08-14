package com.sengmean.demo.service;

import com.sengmean.demo.model.Role;
import com.sengmean.demo.model.Users;
import com.sengmean.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 * Created by Sengmean 5 Nov 2019
 */
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Users> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Users users) {
        repo.save(users);
    }

    @Override
    public void update(int id) {
        repo.update(id);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Users findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public Users findById(int id) {
        return repo.findById(id);
    }

    @Override
    public boolean isUserAlreadyPresent(Users user) {
        return false;
    }


}
