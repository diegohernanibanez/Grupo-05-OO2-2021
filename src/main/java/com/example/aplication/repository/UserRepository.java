package com.example.aplication.repository;

import java.util.List;

import com.example.aplication.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

    List<User> findByEnabledTrue();
    
}
