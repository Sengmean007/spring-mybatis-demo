package com.sengmean.demo.controller;

import com.sengmean.demo.model.Users;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.UserService;
import org.apache.ibatis.annotations.DeleteProvider;
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
    private Users user;
    List<Users> usersList = new ArrayList<>();

    public UserController(){}

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(ModelMap model){
        List<Users> usersList = service.findAll();
        for (Users user : usersList) {
            if (user != null) {
                model.addAttribute("users", user);
                System.out.print("List all user /n :" +"/n"+usersList);
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            } else {
                System.out.println("User doesn't existed..!");
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }
        }
        return null;
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model){
        model.addAttribute("users", user);
        return "user";
    }

    @GetMapping(value = "/u/{username}")
    public Users findByUsername(ModelMap map, @PathVariable("username") String username) {
        try {
            if ((username == null) || (username.equals(""))) {
                return null;
            } else {
                for(Users users: usersList)
                if (users.getUsername(username).equals(username)){
                        System.out.println("User is found "+ username);
                        return users;
                    } else {
                        System.out.println("User Not found "+ username);
                        return null;
                    }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users searchById(@PathVariable("id") Integer id) throws NullPointerException{
        try {
            user = service.findById(id);
            if (user.getId() == id) {
                System.out.println("User is existed "+user);
                return user;
            }else {
                System.out.println("User not found..." +user);
                return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping(value = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) throws NullPointerException{
        try {
            user = service.findById(id);
            if (user.getId() == id) {
                System.out.println(Constant.SUCCESSFUL);
                service.deleteById(id);
            } else {
                System.out.println("User not found "+Constant.FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
