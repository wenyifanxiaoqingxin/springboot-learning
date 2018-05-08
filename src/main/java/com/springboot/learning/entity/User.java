package com.springboot.learning.entity;

import java.io.Serializable;

/**
 * Created by fx on 2018/4/11.
 */
public class User implements Serializable{
    private String username;

    public String getUsername() {
        return username;
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

    private String password;

}
