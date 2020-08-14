package com.sengmean.demo.model;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@ApiModel(description = "To create a user")
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String email;
    private String password;
    private String create_at;
    private String status;

    Users(){}

    /**
     * @param username
     * @param password
//     * @param roles
     */
    public Users(String username, String password,String email, String create_at) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.create_at = create_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUsername() {
        return this.username;
    }

//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
//    private Set<Role> roles;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", create_at=" + create_at +
                '}';
    }

}
