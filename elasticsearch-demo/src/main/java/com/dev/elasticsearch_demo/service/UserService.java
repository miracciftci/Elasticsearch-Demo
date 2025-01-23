package com.dev.elasticsearch_demo.service;

import com.dev.elasticsearch_demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findSearchName(String search);
    User save(User user);
    List<User> findAllUsers();

}
