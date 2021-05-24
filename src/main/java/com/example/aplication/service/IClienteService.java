package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Cliente;



public interface IClienteService {

    public List <Cliente> listarTodos();
    public void guardar (Cliente cliente);
    public Cliente buscarPorID (long id);
    public void eliminar (long id);
   
    
}
