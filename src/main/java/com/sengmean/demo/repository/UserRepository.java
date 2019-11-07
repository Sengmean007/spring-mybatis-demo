package com.sengmean.demo.repository;

import com.sengmean.demo.config.provider.UserProvider;
import com.sengmean.demo.model.Users;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
//    @Select(value = "select id, name, email, password, create_at from users")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "email", column = "email"),
//            @Result(property = "password", column = "password"),
//            @Result(property = "create_at", column = "create_at")
//    })
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
