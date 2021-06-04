package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Rodado;
import com.example.aplication.repository.RodadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RodadoServiceImplements implements IRodadoService {

    @Autowired
    private RodadoRepository rodadoRepository;

    @Override
    public List<Rodado> listarTodos() {   
        return (List<Rodado>)rodadoRepository.findAll();
    }
    @Override
    public void guardar(Rodado rodado) {
        rodadoRepository.save(rodado);       
    }

    @Override
    public Rodado buscarPorID(long id) { 
        return rodadoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        rodadoRepository.deleteById(id);
    }

    @Override
    public Rodado buscarDomino(String dominio) {
       
        return rodadoRepository.findByDominio(dominio);
    }
    
}
