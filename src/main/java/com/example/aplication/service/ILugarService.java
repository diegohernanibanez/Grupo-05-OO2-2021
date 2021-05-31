package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Lugar;

public interface ILugarService {
    public List <Lugar> listarTodos();
    // public List <Lugar> listarActivos();
    public Lugar buscarPorID (int id);
    public void guardar (Lugar user);
    
}
