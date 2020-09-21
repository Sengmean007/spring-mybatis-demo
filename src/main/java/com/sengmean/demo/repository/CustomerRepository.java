package com.sengmean.demo.repository;

import com.sengmean.demo.config.provider.CustomerProvider;
import com.sengmean.demo.model.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface CustomerRepository {

//    @Select(value = "select id, name, gender, address, phone from customer")
//    @Results({
//            @Result(property = "id", column = "id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "gender", column = "gender"),
//            @Result(property = "address", column = "address"),
//            @Result(property = "phone", column = "phone")
//    })
    @SelectProvider(method = "findAll", type = CustomerProvider.class)
    List<Customer> findAll();

    @SelectProvider(method = "findById", type = CustomerProvider.class)
    Customer findById(int id);

//    @Insert(value = "INSERT INTO customer(name, gender, address, phone) VALUES(#{name}, #{gender}, #{address}, #{phone})")
    @InsertProvider(method = "save", type = CustomerProvider.class)
    void save(Customer customer);

//    @Update("UPDATE customer SET name =#{name}, gender =#{gender}, address =#{address}, phone =#{phone} where id = #{id}")
    @UpdateProvider(method = "update", type = CustomerProvider.class)
    void update(Customer customer);

//    @Delete(value = "delete from customer where id = #{id}")
    @DeleteProvider(method = "remove", type = CustomerProvider.class)
    void delete(int id);

    @SelectProvider(method = "findByUsername", type = CustomerProvider.class)
    List<Customer> findByUsername(String userName, int limit, int offset);
}
