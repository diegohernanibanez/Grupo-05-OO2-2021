package com.example.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.aplication.entity.Lugar;
import com.example.aplication.repository.LugarRepository;

@Service
public class LugarServiceImplements implements ILugarService{

    @Autowired
    private LugarRepository LugarRepository;

    @Override
    public List<Lugar> listarTodos() {
        return (List<Lugar>) LugarRepository.findAll();
    }

    // @Override
    // public List<Lugar> listarActivos() {
    //     return (List<Lugar>)LugarRepository.findByEnabledTrue();
        
    //}

    @Override
    public Lugar buscarPorID(long id) { 
        return LugarRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar (Lugar user) {
        LugarRepository.save(user);       
    }
    
}
