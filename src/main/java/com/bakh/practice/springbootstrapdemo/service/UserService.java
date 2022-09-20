package com.bakh.practice.springbootstrapdemo.service;

import com.bakh.practice.springbootstrapdemo.model.Role;
import com.bakh.practice.springbootstrapdemo.model.User;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
public interface UserService {
    User findUser();
    User findUserById(Long id);
    List<User> findAllUsers();
    User editUser(User user);
    boolean createUser(User user);
    boolean deleteUserById(Long id);
}
