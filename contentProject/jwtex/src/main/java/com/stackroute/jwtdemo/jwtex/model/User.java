package com.stackroute.jwtdemo.jwtex.model;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String emailid;
    private String  username, password, address;

    public User() {
    }

    public User(String emailid, String username, String password, String address) {
        this.emailid = emailid;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "emailid='" + emailid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}