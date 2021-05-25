package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.User;



public interface IUserService {

    public List <User> listarTodos();
    public void guardar (User user);
    public User buscarPorID (long id);
    public void eliminar (long id);
   
    
}
