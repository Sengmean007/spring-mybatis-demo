
package com.sengmean.demo.service;

import com.sengmean.demo.model.Customer;
import com.sengmean.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sengmean 9/4/2019
 */
@Service
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveArticle(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void update(int id) {
        customerRepository.update(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer findByUserName(String userName) {
        return customerRepository.findByUsername(userName);
    }
}

