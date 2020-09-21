
package com.sengmean.demo.service;

import com.sengmean.demo.model.Customer;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Customer findById(int id);

    List<Customer> findByUserName(String userName ,int limit, int offset);
}


