package com.example.spring_security.dao;

import com.example.spring_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUsersByEmail(String email);
}
