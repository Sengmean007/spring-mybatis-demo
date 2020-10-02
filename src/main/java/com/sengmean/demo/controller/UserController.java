package com.sengmean.demo.controller;

import com.sengmean.demo.model.Users;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.UserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * To login
     * @param password
     * @return
     * @throws MessagingException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Users> logIn(@RequestParam("name") Integer id,
                                       @RequestParam("password") String password) throws MessagingException {
        if ((id != null && password != null)|| (!id.equals(" ") && !password.equals(" "))){
            user = service.findById(id);
            if ((user.getUsername().equals(id)) && user.getPassword().equals(password)){
                System.out.println("You are logging in...!");
                return new  ResponseEntity<Users> (user, HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    /**
     * To get all users
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(){
        List<Users> usersList = service.findAll();
        if (usersList.size() > 0) {
            for (Users user : usersList) {
                System.out.print("List all user /n :" + "/n" + usersList);
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }
        }
        System.out.println("User doesn't existed..!");
        return new ResponseEntity<>(usersList, HttpStatus.BAD_REQUEST);
    }

    /**
     * To find user by username
     * @param username
     * @return
     */
    @RequestMapping (value = "/name/{username}", method = RequestMethod.GET)
    public ResponseEntity<List<Users>> findByUsername(@PathVariable("username") String username) throws NullPointerException {
        try {
            if ((username != null) || (!username.equals(""))) {
                usersList = service.getAllByUsername(username);
                if (usersList.size() > 0)
                    for (Users user : usersList)
                    {
                        System.out.println("Finding is : " + username);
                        System.out.println("Found : " + usersList);
                        return new ResponseEntity<>(usersList, HttpStatus.OK);
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finding is : " + username);
        System.out.println(username + " not existed...!");
        return new ResponseEntity<>(usersList, HttpStatus.BAD_REQUEST);
    }

    /**
     * To find by ID
     * @param id
     * @return
     * @throws NullPointerException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users findOne(@PathVariable("id") Integer id) throws NullPointerException{
        try {
            if (id != null || !id.equals("")){
                List<Users> usersList = service.findAll();
                // Search id in list
                for (int i = 0; i < usersList.size(); i++) {
                    if (usersList.get(i).getId() == id) {
                        user = service.findById(id);
                        System.out.println("User is : " + user);
                        return user;
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("User not found... ");
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
            if (id != null || !id.equals("")) {
                List<Users> usersList = service.findAll();
                // Search id in list
                for (int i = 0; i < usersList.size(); i++) {
                    if (usersList.get(i).getId() == id) {
                        System.out.println(Constant.SUCCESSFUL);
                        service.deleteById(id);
                    }
                }
            } else {
                System.out.println("User not found "+Constant.FAIL);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * To update and save user
     * @param id
     * @throws SqlSessionException
     * @throws NullPointerException
     */
    @RequestMapping(value = "/update/{id}", method = { RequestMethod.PUT})
    public ResponseEntity<Users> update(@PathVariable("id") Integer id, @RequestBody Users u){
        try {
            if (id != null || !id.equals("")) {
                // Search id in list
                for (int i = 0; i < usersList.size(); i++) {
                    if (usersList.get(i).getId() == id) {
                        u = service.update(id);
                    }
                }
                return new ResponseEntity<>(u, HttpStatus.OK);
            }else {
                   return null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(u, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param user
     * @return
     * @throws NullPointerException
     */
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Users save(@RequestBody Users user) throws NullPointerException {
        if (user != null || !user.equals("")) {
            service.save(user);
            return user;
        }

        return null;
    }
}
