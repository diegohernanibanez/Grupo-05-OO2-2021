package com.example.aplication.repository;

import java.util.List;

import com.example.aplication.entity.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{

    List<Persona> findAll();
    List<Persona> findByDni (Long dni); 
    Persona findByDni(long dni);
}
