package com.bakh.practice.springbootstrapdemo.service;

import com.bakh.practice.springbootstrapdemo.model.Role;
import com.bakh.practice.springbootstrapdemo.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
