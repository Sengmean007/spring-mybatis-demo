//package com.sengmean.demo.controller;
//
//import com.sengmean.demo.model.Customer;
//import com.sengmean.demo.pojo.Constant;
//import com.sengmean.demo.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * Sengmean 01/04/2019
// */
//@RestController
//@RequestMapping("/api/customer")
//public class CustomerController {
//
//    private CustomerService customerService;
//    private Customer customer;
//
//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }
//
//    /**
//     * Get all Customer
//     * @return
//     */
//   @RequestMapping("/list")
//    public ResponseEntity<?> getAll(){
//        List<Customer> customers = customerService.findAll();
//        return new ResponseEntity<>(customers, HttpStatus.OK);
//    }
//
//    /**
//     * To get Customer
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Customer> findOne(@PathVariable("id") Integer id) {
//        Customer customer = customerService.findById(id);
//        if (id != null) {
//            String mess = Constant.SUCCESSFUL;
//            System.out.println("Customer is founded");
//            return new ResponseEntity<>(customer, HttpStatus.OK);
//        } else {
//            String message = Constant.FAIL;
//            System.out.println("Not founded Customer");
//            return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    /**
//     * To deleted customer
//     * @param id
//     */
//    @RequestMapping("/{id}")
//    public void delete(@RequestParam("id") Integer id) {
//        if (id != null){
//            customerService.delete(id);
//            String message = Constant.SUCCESSFUL;
//            System.out.println("Deleted " + message);
//        } else {
//            String message = Constant.FAIL;
//            System.out.println("Delete " + message);
//        }
//    }
////
////    /**
////     * To created new article
////     * @param article
////     * @return
////     */
////    @RequestMapping(value = "/add", method = RequestMethod.PUT)
////    public ResponseEntity<Article> createArticle(Article article) {
////
////        article.setName(article.getName());
////        article.setGender(article.getGender());
////        article.setAddress(article.getAddress());
////        article.setPhone(article.getPhone());
////        articleService.saveArticle(article);
////        String message = Constant.SUCCESSFUL;
////       return new ResponseEntity<Article>(article, HttpStatus.OK);
////    }
//
//    /**
//     * To update article by id
//     * @param id
//     */
//    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> update(Integer id) {
//        customerService.findById(id);
//        Customer customer = new Customer();
//        if ((customer.getId() == 0) || (customer.equals("") )){
//            customer.setName("Hot news");
//            customer.setAddress("Phnom penh");
//            customer.setGender("Male");
//            customer.setPhone("0987676564");
//            customerService.saveArticle(customer);
//            String message = Constant.SUCCESSFUL;
//            return new ResponseEntity<>("Save "+ message, HttpStatus.OK);
//        } else {
//            customer.setName("Hot Dara");
//            customer.setAddress("Phnom penh");
//            customerService.update(id);
//            String message = Constant.SUCCESSFUL;
//            return new ResponseEntity<>("Update"+message, HttpStatus.OK);
//        }
//    }
//}
