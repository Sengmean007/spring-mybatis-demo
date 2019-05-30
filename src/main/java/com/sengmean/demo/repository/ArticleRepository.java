package com.sengmean.demo.repository;

import com.sengmean.demo.model.Article;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sun.text.normalizer.UCharacter;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface ArticleRepository {

    @Select(value = "select id, name, gender, address, phone from articles")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone")
    })
    List<Article> findAll();

    @Select(value = "select id, name, gender, address, phone from articles")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone")
    })
    List<Article> findAllarticle();

    @Select(value = "select id, name, address, gender, phone from articles where id =#{id}")
    Article findById(int id);

    @Select(value = "insert id, name, gender, address, phone into articles")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "address", column = "address"),
            @Result(property = "phone", column = "phone")
    })
    void saveArticle(Article article);

    @Update("update table articles set (name =#{name}, gender =#{gender}, address =#{address}, phone =#{phone where id =#{id}})")
    void update(int id);

    @Delete(value = "Delete from articles where id =#{id}")
    void deleteById(String id);


}
