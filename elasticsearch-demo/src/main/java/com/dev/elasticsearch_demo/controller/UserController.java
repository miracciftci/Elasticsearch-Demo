package com.dev.elasticsearch_demo.controller;

import com.dev.elasticsearch_demo.model.User;
import com.dev.elasticsearch_demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping("/getUsers/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search) {
        List<User> users =  userService.findSearchName(search);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {;
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(userService.findAllUsers());
    }



}
