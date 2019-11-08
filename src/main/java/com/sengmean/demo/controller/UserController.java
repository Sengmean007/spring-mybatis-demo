package com.sengmean.demo.controller;

import com.sengmean.demo.model.Users;
import com.sengmean.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;
    private Users users;
    List<Users> usersList = new ArrayList<>();
    public UserController(){}

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(ModelMap model){
        List<Users> usersList = service.findAll();
        model.addAttribute("users", users);
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model){
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping(value = "/u/{username}")
    public Users findByUsername(ModelMap map, @PathVariable("username") String username) throws NullPointerException {
        try {
            users = service.findByUsername(username);
            if (users.getUsername() != username) {
                System.out.println("User is existed ");
                System.out.println("UserName is : "+username);
                return users;
            } else {
                System.out.println("User Not found ");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
           return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users searchById(@PathVariable("id") Integer id) throws NullPointerException{
//        Users user = service.findById(id);
        try {
            usersList = service.findAll();
            for (Users u: usersList)
            if (u.getId() == id) {
                System.out.println("User id found id is " + id);
                System.out.println("User is existed "+u);
                return u = service.findById(id);
            }else {
                System.out.println("User not found...");
                return null;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public void remove(@PathVariable("id") Integer id) throws NullPointerException{
//        Users user = service.findById(id);
        try {
            usersList = service.findAll();
            for (Users u: usersList)
            if (u.getId() == id) {
                System.out.println("Success...!");
                service.deleteById(id);
            } else {
                System.out.println("User not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
