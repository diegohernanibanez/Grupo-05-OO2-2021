package com.example.aplication.repository;


import java.util.List;

import com.example.aplication.entity.Lugar;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugarRepository extends CrudRepository <Lugar, Long> {
    
    List<Lugar> findAll();
   // List<Lugar> findByEnabledTrue();
}