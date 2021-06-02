package com.example.aplication.repository;

import com.example.aplication.entity.Rodado;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodadoRepository extends CrudRepository <Rodado, Long> {
}
