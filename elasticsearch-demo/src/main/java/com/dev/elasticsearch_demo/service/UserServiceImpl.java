package com.dev.elasticsearch_demo.service;

import com.dev.elasticsearch_demo.model.User;
import com.dev.elasticsearch_demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findSearchName(String name) {
        return userRepository.findUsersByNameLike(name);
        //return userRepository.findSearchByName(name);
        //return userRepository.findSearchByNameLikeWithNativeQuery(name);
    }

    @Override
    public List<User> findSearchNameAndSurname(String name, String surname) {
        return userRepository.findSearchByNameAndSurname(name, surname);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        // Iterable türünde User listesi döndürür
        List<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }



}
