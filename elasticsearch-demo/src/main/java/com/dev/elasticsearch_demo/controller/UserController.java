package com.dev.elasticsearch_demo.controller;

import com.dev.elasticsearch_demo.model.User;
import com.dev.elasticsearch_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/getUsers/{search}")
    public ResponseEntity<List<User>> getUsers(@PathVariable String search) {
        List<User> users =  userRepository.findUsersByNameLike(search);
        return ResponseEntity.ok(users);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {;
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getAllUser() {
        // Iterable türünde User listesi döndürür
        List<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }



}
