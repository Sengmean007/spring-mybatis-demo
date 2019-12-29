package com.sengmean.demo.controller;

import com.sengmean.demo.model.Customer;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.CustomerService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Sengmean 01/04/2019
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;
    private Customer customer;

    private static final String  MESSAGE_SUCCESS = Constant.SUCCESSFUL;
    private static final String  MESSAGE_FAIL = Constant.FAIL;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Get all Customer
     * @return
     */
   @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        List<Customer> customers = customerService.findAll();
        if (customers.size() > 0) {
            System.out.println(MESSAGE_SUCCESS);
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customers, HttpStatus.BAD_GATEWAY);
        }
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
                    System.out.println("Customer is founded"+" "+ MESSAGE_SUCCESS);
                    return new ResponseEntity<Customer>(customer, HttpStatus.OK);
                } else {
                    System.out.println("Not founded Customer"+" "+ MESSAGE_FAIL);
                    return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
                }
            } else {
                System.out.println("Not founded Customer"+ MESSAGE_FAIL);
                return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.BAD_REQUEST);
    }

    /**
     * To find customer by Customer Name
     * @param map
     * @param name
     * @return
     */
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Customer> findByUsername(ModelMap map, @PathVariable("name") String name) {
        try {
            if ((name == null) || (name.equals(""))) {
                return null;
            } else {
                customer = customerService.findByUserName(name);
                    if (customer.getName().equals(name)){
                        System.out.println("User is found "+ name +" "+ MESSAGE_SUCCESS);
                        return new ResponseEntity<>(customer, HttpStatus.OK);
                    } else {
                        System.out.println("User Not found "+ name +" "+ MESSAGE_FAIL);
                        return new ResponseEntity<>(customer, HttpStatus.BAD_GATEWAY);
                    }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(customer, HttpStatus.BAD_GATEWAY);
    }

    /**
     * To deleted customer
     * @param id
     */
    @DeleteMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        if (id != null || !id.equals(" ")){
             findOne(id);
            if (customer.getId() == id) {
                customerService.delete(id);
                System.out.println("Deleted " + MESSAGE_SUCCESS);
            } else {
                System.out.println("Delete " + MESSAGE_FAIL);
            }
        } else {
            System.out.println("Delete " + MESSAGE_FAIL);
        }
    }
//
//    /**
//     * To created new article
//     * @param article
//     * @return
//     */
//    @RequestMapping(value = "/add", method = RequestMethod.PUT)
//    public ResponseEntity<Article> createArticle(Article article) {
//
//        article.setName(article.getName());
//        article.setGender(article.getGender());
//        article.setAddress(article.getAddress());
//        article.setPhone(article.getPhone());
//        articleService.saveArticle(article);
//        String message = Constant.SUCCESSFUL;
//       return new ResponseEntity<Article>(article, HttpStatus.OK);
//    }

    /**
     * To update article by id
     * @param id
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(Integer id) {
        customerService.findById(id);
        Customer customer = new Customer();
        if ((customer.getId() == 0) || (customer.equals("") )){
            customer.setName("Hot news");
            customer.setAddress("Phnom penh");
            customer.setGender("Male");
            customer.setPhone("0987676564");
            customerService.saveArticle(customer);
            String message = Constant.SUCCESSFUL;
            return new ResponseEntity<>("Save "+ message, HttpStatus.OK);
        } else {
            customer.setName("Hot Dara");
            customer.setAddress("Phnom penh");
            customerService.update(id);
            String message = Constant.SUCCESSFUL;
            return new ResponseEntity<>("Update"+message, HttpStatus.OK);
        }
    }
}
