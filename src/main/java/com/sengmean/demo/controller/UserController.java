package com.sengmean.demo.controller;

import com.sengmean.demo.model.Users;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.UserService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sengmean 40/12/2019
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService service;
    private Users user;
    List<Users> usersList;

    public UserController(){}

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<?> logIn(ModelMap model){
        return null;
    }

    /**
     * To get all users
     * @param model
     * @return
     */
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

//    /**
//     * To get user
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String userPage(ModelMap model){
//        model.addAttribute("users", user);
//        return "user";
//    }

    /**
     * To find user by username
     * @param map
     * @param username
     * @return
     */
    @GetMapping(value = "/u/{username}")
    public Users findByUsername(ModelMap map, @PathVariable("username") String username) {
        try {
            if ((username == null) || (username.equals(""))) {
                System.out.println(username + "not existed...!");
                return null;
            } else {
                    user = service.findByUsername(username);
                if (username.equals(user.getUsername())){
                    System.out.println("User is found "+ username);
                    System.out.println("Found : "+user);
                        return user;
                    }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To find by ID
     * @param id
     * @return
     * @throws NullPointerException
     */
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

    /**
     * To remove user
     * @param id
     * @throws NullPointerException
     */
    @RequestMapping(value = "/remove/{id}", method = {RequestMethod.DELETE})
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

    /**
     *
     * @param id
     * @return
     * @throws SqlSessionException
     * @throws NullPointerException
     */
    @RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT})
    public ResponseEntity<Users> update(@PathVariable("id") Integer id) throws SqlSessionException, NullPointerException {
        try {
            if (id != 0 || !id.equals(" ")) {
                user = service.findById(id);
                if (user.getId() == id) {
                    user.setUsername("Golder Man");
                    user.setEmail("sopheary.kea@gmail.com");
                    service.update(id);
                    user = service.findById(id);
                    String message = Constant.SUCCESSFUL;
                    System.out.println(message);
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
            }  else {
                return new ResponseEntity<>(user, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * To Add user
     * @param users
     * @return
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Users save( Users users) {
        List<Users> userlist = new ArrayList<>();
        userlist = service.findAll();
        for (int i = userlist.size(); i <= userlist.size(); i ++) {
            users.setId(i + 1);
            users.setUsername("Sengmean123");
            users.setEmail("male");
            users.setPassword("1q2w3e4r5t");
            users.setCreate_at("2020-07-13 17:37:48");
            service.save(users);
        }
        return users;
    }
}
