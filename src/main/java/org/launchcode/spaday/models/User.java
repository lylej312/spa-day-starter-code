package org.launchcode.spaday.models;

import java.util.Date;

public class User {

    private int id;
    private static int nextId = 0;
    private String username;
    private String email;
    private String password;
    private Date date;

    public User() {
        nextId++;
        id = nextId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
