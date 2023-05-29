package com.example.spring_security.service;

import com.example.spring_security.entity.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    List<Role> getAllRoles();
}