package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Ciudad;
import com.example.aplication.repository.CiudadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImplements implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> listaCiudades() {
        
        return (List<Ciudad>) ciudadRepository.findAll();
    }

    
}
