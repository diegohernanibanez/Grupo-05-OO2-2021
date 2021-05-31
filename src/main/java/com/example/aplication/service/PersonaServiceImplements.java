package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Persona;
import com.example.aplication.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImplements implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listarTodos() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public List<Persona> listarActivos() {
        return (List<Persona>)personaRepository.findByEnabledTrue();
        
    }

    @Override
    public Persona buscarPorID(long id) { 
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar (Persona user) {
        personaRepository.save(user);       
    }

    @Override
    public List<Persona> listarDni(Long dni) {
        
        return personaRepository.findByDni(dni);
    }


    
    
}
