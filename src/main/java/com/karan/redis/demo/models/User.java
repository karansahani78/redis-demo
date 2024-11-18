package com.karan.redis.demo.models;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class User implements Serializable {

    private String userId;
    private String name;
    private String phone;

    public String getUserId() {
        return userId;
    }

    public User() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

}
