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
        for (Users users : usersList) {
            if (users != null) {
                model.addAttribute("users", users);
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
        model.addAttribute("users", users);
        return "user";
    }

    @GetMapping(value = "/u/{username}")
    public Users findByUsername(ModelMap map, @PathVariable("username") String username) throws NullPointerException {
        try {
            usersList = service.findAll();
            if ((username == null) || (username.equals(""))) {
                System.out.println("Please input username..! ");
                return null;
            } else {
                for (Users u: usersList)
                    users = service.findByUsername(username);

                if (users.getUsername() == username){
                    System.out.println("User Not found "+ users);
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
            users = service.findById(id);
            if (users.getId() == id) {
                System.out.println("User is existed "+users);
                return users;
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
        users = service.findById(id);
        try {
            if (users.getId() == id) {
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
