package com.sengmean.demo.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.*;

@ApiModel(description = "To create a user")
@Entity
@Table(name = "users")
public class Users implements Pageable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    private String create_At;
    private String status;

    // Pager param
    private int limit = 20;
    private int offset = 1;

    public Users(){}

    /**
     * @param username
     * @param password
//     * @param roles
     */
    public Users(String username, String password,String email, String create_At) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.create_At = create_At;
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

    public String getCreate_At() {
        return create_At;
    }

    public void setCreate_At(String create_At) {
        this.create_At = create_At;
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
                ", create_At=" + create_At +
                '}';
    }

    /**
     * User sorted
     */
    private Sort sort = new Sort(Sort.Direction.DESC, "id");
    public Users(int limit, int offset) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must not be less than one!");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("Offset index must not be less than zero!");
        }
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public int getPageNumber() {
        return offset / limit;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return new Users(getPageSize(), (int) (getOffset() + getPageSize()));
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    private Pageable previous() {
        // The integers are positive. Subtracting does not let them become bigger than integer.
        return hasPrevious() ?
                new Users(getPageSize(), (int) (getOffset() - getPageSize())): this;
    }

    @Override
    public Pageable first() {
        return new Users(getPageSize(), 1);
    }

    @Override
    public boolean hasPrevious() {
        return offset > limit;
    }
}
