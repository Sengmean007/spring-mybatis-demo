package com.sengmean.demo.controller;

import com.sengmean.demo.model.User;
//import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.UserService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private User user;
    List<User> usersList;

    public UserController(){}

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * To login
     * @param password
     * @return
     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String logIn(@RequestParam("name") Integer id,
//                                       @RequestParam("password") String password)  {
//        if (id != null && (password != null || !password.equals(" "))) {
//            user = service.findById(id);
//        }
//        return "login";
//    }

    /**
     * To get all users
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> list(){
        List<User> usersList = service.findAll();
        if (!usersList.isEmpty()) {
            for (User user : usersList) {
                System.out.println("Users are existing ..."+usersList );
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }
        }
        System.out.println("User doesn't existed..!");
        return new ResponseEntity<>(usersList, HttpStatus.BAD_REQUEST);
    }
    /**
     * @param user
     * @return u
     * @throws NullPointerException
     */
    @PostMapping("/register")
    public ResponseEntity<List<User>> save(@RequestBody User user) {
    	List<User> users = new ArrayList<>();
    	users = service.findAll();
        boolean isFound = true;
        if (isFound){
            user.setUsername(user.getUsername());
            user.setPassword(user.getPassword());
            user.setEmail(user.getEmail());
            user.setCreate_time(user.getCreate_time()) ;
            user.setStatus(user.getStatus());
            service.save(user);
            users.add(user);
        }
        
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    /**
     * To find user by username
     * @param username
     * @return u
     */
    @GetMapping ("/name/{username}")
    public ResponseEntity<List<User>> findByUsername(@PathVariable("username") String username)  {

            if ((username != null) || (!username.isEmpty())) {
                usersList = service.getAllByUsername(username);
                if (!usersList.isEmpty())
                    for (User user : usersList)
                    {
                        System.out.println("Finding is : " + username);
                        System.out.println("Found : " + usersList);
                        return new ResponseEntity<>(usersList, HttpStatus.OK);
                    }
            }

        System.out.println("Finding is : " + username);
        System.out.println(username + " not existed...!");
        return new ResponseEntity<>(usersList, HttpStatus.BAD_REQUEST);
    }

    /**
     * To find by ID
     *
     * @param id
     * @return u
     * @throws NullPointerException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") int id) {

            List<User> usersList = service.findAll();
            // Search id in list
            for (User user : usersList) {
                if (user.getId() == id) {
                    service.findById(id);
//                    System.out.println("Found ");
                    System.out.println("User is found: " + user);
                    return user;
                } 
            }
            System.out.println("Sorry...! User not found... ");
        
        return user;
    }
    /**
     * To remove user
     * @param id
     * @throws NullPointerException
     */
    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable int id) {

            List<User> usersList = service.findAll();
            // Search id in list
            for (User user : usersList) {
                if (user.getId() == id) {
                    System.out.println("SUCCESSFUL");
                    service.remove(id);
                }
            }

    }

    /**
     * To update and save user
     * @param id
     * @throws SqlSessionException
     * @throws NullPointerException
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody() Integer id, @RequestBody() User u){

    	User user = service.findById(id);
    	List<User> users = new ArrayList<User>();
                if (user.getId() == id) {
                	u.setId(user.getId());
                	u.setUsername(user.getUsername());
                	u.setEmail(user.getEmail());
                	u.setPassword(user.getPassword());
                	u.setCreate_time(user.getCreate_time());
                	u.setStatus(user.getStatus());
                    u = service.update(id);
                    users.add(u);
                    return new ResponseEntity<>(u, HttpStatus.OK);
                } else {
                	 return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
                }
                
    }
    

   
    @SuppressWarnings("null")
	@GetMapping ("/single/{username}")
    public ResponseEntity<User> findUsername(@PathVariable("username") String username) {

            if ((username != null) || (!username.isEmpty())) {
                usersList = service.getAllByUsername(username);
                if (!usersList.isEmpty())
                    for (User user : usersList)
                    {
                        System.out.println("Finding is : " + username);
                        System.out.println("Found : " + user);
                        return new ResponseEntity<>(user, HttpStatus.OK);
                    }
            }

        System.out.println("Finding is : " + username);
        System.out.println("Username :"+username + " is not existed...!");
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
}
