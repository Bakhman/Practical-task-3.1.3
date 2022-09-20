package com.bakh.practice.springbootstrapdemo.repository;

import com.bakh.practice.springbootstrapdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bakhmai Begaev
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
