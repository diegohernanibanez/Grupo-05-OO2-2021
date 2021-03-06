package com.example.aplication.repository;

import java.util.List;

import com.example.aplication.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();
    List<Role> findByEnabledTrue();
}
