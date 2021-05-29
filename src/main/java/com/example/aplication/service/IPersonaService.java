package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Persona;

public interface IPersonaService {

    public List <Persona> listarTodos();
    public List <Persona> listarActivos();
    public Persona buscarPorID (long id);
    public void guardar (Persona user);

}
