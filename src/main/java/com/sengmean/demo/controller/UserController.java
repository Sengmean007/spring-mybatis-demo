package com.sengmean.demo.controller;

import com.sengmean.demo.model.Users;
import com.sengmean.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;
    private Users users;

    public UserController(){}

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(ModelMap model){
        List<Users> usersList = service.findAll();
        model.addAttribute("users", users);
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listq(ModelMap model){
        List<Users> users = service.findAll();
        model.addAttribute("users", users);
        return "user";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model){
        model.addAttribute("users", users);
        return "user";
    }

//    /**
//     *
//     * @param username
//     * @return
//     */
//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public ResponseEntity<?> findByName(@PathVariable("name") String username){
//        users = service.findByUsername(username);
//        if (users.equals(null) || users.equals("")) {
//
//            return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
//        } else {
//            System.out.println(users);
//            return new ResponseEntity<>(users, HttpStatus.FOUND);
//        }
//    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String findByUsername(ModelMap m, @RequestParam("username") String username){
        Users user = service.findByUsername(username);
        System.out.println(user.getUsername());
        m.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> searchById(@PathVariable("id") Integer id) {
        Users user = service.findById(id);
        if (user != null){
            return new ResponseEntity<>(users, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(users, HttpStatus.FOUND);
        }
    }
}
