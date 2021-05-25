package com.example.aplication.service;

import java.util.List;
import com.example.aplication.entity.Role;

public interface IRoleService {

    public List <Role> listaRoles();
    public List <Role> listarTodos();
    public void guardar (Role user);
    public Role buscarPorID (long id);
    public void eliminar (long id);

    
}
