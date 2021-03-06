package com.sengmean.demo.repository;

import com.sengmean.demo.config.provider.UserProvider;
import com.sengmean.demo.model.Users;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @SelectProvider(method = "findAll", type = UserProvider.class)
    List<Users> findAll();

    @SelectProvider(method = "getAllByUsername", type = UserProvider.class)
    List<Users> searchByUsername(String username);

    @SelectProvider(method = "save", type = UserProvider.class)
    void save(Users user);

    @SelectProvider(method = "update", type = UserProvider.class)
    Users update(int id);

    @SelectProvider(method = "remove", type = UserProvider.class)
    void deleteById(Integer id);

    @SelectProvider(method = "findById", type = UserProvider.class)
    Users findById(int id);
}
