package com.example.aplication.repository;

import com.example.aplication.entity.Ciudad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

}
