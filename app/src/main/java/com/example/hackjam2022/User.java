package com.example.hackjam2022;

import android.os.Bundle;

public class User {

    public String fullname, email;

    public User(){

    }

    public User(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }
}