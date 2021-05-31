package com.example.aplication.repository;

import java.util.List;

import com.example.aplication.entity.Permiso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends CrudRepository <Permiso, Long> {
    
    List<Permiso> findAll();
   // List<Permiso> findByEnabledTrue();
    
}
