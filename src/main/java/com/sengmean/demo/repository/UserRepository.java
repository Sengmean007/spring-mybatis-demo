package com.sengmean.demo.repository;

import com.sengmean.demo.config.provider.UserProvider;
import com.sengmean.demo.model.Users;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    @SelectProvider(method = "findAll", type = UserProvider.class)
    List<Users> findAll();

    @Select(value = "select * from users where username = #{username}")
    Users findByUsername(String username);

    Users save(Users users);

    void update(int id);

    void deleteById(Integer id);

//    @Select(value = "select * from users where id = #{id}")
    @SelectProvider(method = "findById", type = UserProvider.class)
    Users findById(int id);
}
