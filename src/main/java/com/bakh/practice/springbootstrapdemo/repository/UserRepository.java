package com.bakh.practice.springbootstrapdemo.repository;

import com.bakh.practice.springbootstrapdemo.model.Role;
import com.bakh.practice.springbootstrapdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bakhmai Begaev
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
