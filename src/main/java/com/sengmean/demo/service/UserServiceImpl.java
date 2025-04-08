package com.sengmean.demo.service;

import com.sengmean.demo.model.User;
import com.sengmean.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);

    }

    @Override
    public User update(int id) {
        return repo.update(id);
    }

    @Override
    public void remove(int id) {
        repo.remove(id);
    }

    @Override
    public User findById(int id) {
        repo.findById(id);
        return repo.findById(id);
    }

    @Override
    public boolean isUserAlreadyPresent(User user) {
        return false;
    }

    @Override
    public List<User> getAllByUsername(String username) {
        return repo.searchByUsername(username);
    }

    @Override
    public User findUsername(String username) {
        return repo.findUsername(username);
    }




}
