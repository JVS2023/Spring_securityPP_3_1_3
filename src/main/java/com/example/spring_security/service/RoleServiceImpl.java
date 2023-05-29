package com.example.spring_security.service;

import com.example.spring_security.dao.RoleRepository;
import com.example.spring_security.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final EntityManager entityManager;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, EntityManager entityManager) {
        this.roleRepository = roleRepository;
        this.entityManager = entityManager;
    }


    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
