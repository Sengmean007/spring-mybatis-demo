package com.sengmean.demo.model;

import java.util.Date;

public class Role {
    private int id;
    private String role_name;
    private int user_Id;

    /**
     *
     * @param id
     * @param role_name
     * @param user_Id
     */
    public Role(int id, String role_name, int user_Id) {
        this.id = id;
        this.role_name = role_name;
        this.user_Id = user_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }
}

