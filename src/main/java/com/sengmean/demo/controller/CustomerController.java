package com.sengmean.demo.controller;

import com.sengmean.demo.model.Customer;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.CustomerService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sengmean 01/04/2019
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;
    private Customer customer;
    private List<Customer> customers = new ArrayList<>();

    private static final String MESSAGE_SUCCESS = Constant.SUCCESSFUL;
    private static final String MESSAGE_FAIL = Constant.FAIL;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * To get all Customers
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> getAll() {
        List<Customer> customers = customerService.findAll();
        System.out.println(customers);
        Map<String, Object> map = new HashMap<>();
        if (customers.size() < 0) {
            map.put("code", 400);
            map.put("MSG", "Notfound");
            return map;
        }
        map.put("code", 200);
        map.put("data", customers);
        return map;

    }

    /**
     * To get Customer
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findOne(@PathVariable("id") Integer id) {
        try {
            if (id != null || !id.equals("")) {
                customer = customerService.findById(id);
                if (customer.getId() == id) {
                    System.out.println("Customer is founded" + " " + MESSAGE_SUCCESS);
                    return new ResponseEntity<Customer>(customer, HttpStatus.OK);
                } else {
                    System.out.println("Not founded Customer" + " " + MESSAGE_FAIL);
                    return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
                }
            } else {
                System.out.println("Not founded Customer" + MESSAGE_FAIL);
                return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);
    }

    /**
     * To find customer by Customer Name
     * @param name
     * @return
     */
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<List<Customer>> findByUsername(@PathVariable("name") String name) {
        try {
            if ((name == null) || (name.equals(""))) {
                return null;
            } else {
                customers = customerService.findByUserName(name);
                if (customers.size() > 0) {
                    System.out.println("User is found " + name + " " + MESSAGE_SUCCESS);
                    return new ResponseEntity<>(customers, HttpStatus.OK);
                } else {
                    System.out.println("User Not found " + name + " " + MESSAGE_FAIL);
                    return new ResponseEntity<>(customers, HttpStatus.BAD_GATEWAY);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To deleted customer
     * @param id
     */
    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.DELETE})
    public ResponseEntity<Customer> remove(@PathVariable("id") Integer id) throws NullPointerException {
        try {
            if (id != null || !id.equals(" ")) {
                Customer customer1 = customerService.findById(id);
                if (customer1.getId() == id) {
                    customerService.delete(id);
                    System.out.println("Deleted " + MESSAGE_SUCCESS);
                } else {
                    System.out.println("Delete " + MESSAGE_FAIL);
                }
            }
        } catch (NullPointerException ex) {
            ex.getMessage();
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * To update customer by existing id
     * @param id
     * @return as customer
     * @throws SqlSessionException
     */
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<Customer> update(@PathVariable("id") Integer id) throws SqlSessionException, NullPointerException {
        try {
            if (id != 0 || !id.equals(" ")) {
                Customer customer = customerService.findById(id);
                if (customer.getId() == id) {
                    customer.setName("Golder Man");
                    customer.setGender("Female");
                    customerService.update(customer);
                    Customer updateCustomer = customerService.findById(id);
                    String message = Constant.SUCCESSFUL;
                    System.out.println(message);
                    return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
                }
            }  else {
                return new ResponseEntity<>(customer, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To add new customer
     * @param customer
     * @return
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Customer save( Customer customer) {
        List<Customer> cus = new ArrayList<>();
        cus = customerService.findAll();
        for (int i = cus.size(); i <= cus.size(); i ++) {
//            customer.setId(i + 1);
            customer.setName("Sengmean");
            customer.setGender("Female");
            customer.setAddress("Phnom Penh, Cambodia");
            customer.setPhone("0987676564");
            customerService.save(customer);
        }
        return customer;
    }
}
