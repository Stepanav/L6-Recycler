package ru.gb.course1.l6_recycler.domain;

import java.io.Serializable;

public class User implements Serializable {

    private String user_data;

    public User(String user_data, int j) {
        this.user_data = user_data;

    }

    public String getUser_data() {
        return user_data;
    }

    public void setUser_data(String user_data) {
        this.user_data = user_data;
    }

}