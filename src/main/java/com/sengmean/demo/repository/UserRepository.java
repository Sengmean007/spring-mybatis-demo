package com.sengmean.demo.repository;

import com.sengmean.demo.config.provider.UserProvider;
import com.sengmean.demo.model.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    @SelectProvider(method = "findAll", type = UserProvider.class)
//@Select(value = "select id, username, password, email, status from user")
//@Results({
//        @Result(property = "id", column = "id"),
//        @Result(property = "username", column = "username"),
//        @Result(property = "password", column = "password"),
//        @Result(property = "email", column = "email"),
//        @Result(property = "status", column = "status")
//})
    List<User> findAll();

    @SelectProvider(method = "findByUsername", type = UserProvider.class)
    List<User> searchByUsername(String username);

    @SelectProvider(method = "getByUsername", type = UserProvider.class)
    User findUsername(String username);

    @SelectProvider(method = "save", type = UserProvider.class)
    void save(User user);

    @SelectProvider(method = "update", type = UserProvider.class)
    User update(int id);

    @SelectProvider(method = "remove", type = UserProvider.class)
    void remove(int id);

    @SelectProvider(method = "findById", type = UserProvider.class)
    User findById(int id);
}
