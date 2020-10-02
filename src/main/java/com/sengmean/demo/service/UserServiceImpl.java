package com.sengmean.demo.service;

import com.sengmean.demo.model.Users;
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
    public List<Users> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(Users user) {
         repo.save(user);
    }

    @Override
    public Users update(int id) {
        return repo.update(id);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Users findById(int id) {
        return repo.findById(id);
    }

    @Override
    public boolean isUserAlreadyPresent(Users user) {
        return false;
    }

    @Override
    public List<Users> getAllByUsername(String username) {
        return repo.searchByUsername(username);
    }


}
