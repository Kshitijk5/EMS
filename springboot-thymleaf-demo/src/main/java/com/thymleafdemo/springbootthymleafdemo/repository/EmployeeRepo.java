package com.thymleafdemo.springbootthymleafdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymleafdemo.springbootthymleafdemo.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,String> {
    
    Optional<Employee> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<Employee> findByUsernameOrEmail(String username,String email);
}
