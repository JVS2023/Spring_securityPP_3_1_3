package com.example.spring_security.service;

import com.example.spring_security.dao.UserRepository;
import com.example.spring_security.entity.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImp(UserRepository userRepository,@Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return userRepository.getById(id);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        userRepository.save(updatedUser);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User findUsersByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

}

