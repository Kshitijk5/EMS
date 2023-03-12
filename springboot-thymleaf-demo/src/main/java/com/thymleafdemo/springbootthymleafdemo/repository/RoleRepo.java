package com.thymleafdemo.springbootthymleafdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thymleafdemo.springbootthymleafdemo.entities.Roles;

public interface RoleRepo extends JpaRepository<Roles,Long> {
     Roles findByName(String role);
}
