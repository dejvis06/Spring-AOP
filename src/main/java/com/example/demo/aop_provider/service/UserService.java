package com.example.demo.aop_provider.service;

import com.example.demo.aop_provider.entity.User;

public class UserService {

    public User updateUser(User user) {
        user.setUsername("newUsername");
        return user;
    }
}
