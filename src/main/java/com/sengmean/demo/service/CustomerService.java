
package com.sengmean.demo.service;

import com.sengmean.demo.model.Customer;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface CustomerService {

    List<Customer> findAll();

    Customer saveArticle(Customer customer);

    void update(int id);

    void delete(int id);

    Customer findById(int id);

    Customer findByUserName(String userName);
}


