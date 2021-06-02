package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Rodado;



public interface IRodadoService {

    public List <Rodado> listarTodos();
    public void guardar (Rodado rodado);
    public Rodado buscarPorID (long id);
    public void eliminar (long id);
   
    
}
