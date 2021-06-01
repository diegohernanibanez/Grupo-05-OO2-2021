package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Permiso;

public interface IPermisoService {

    public List <Permiso> listarTodos();
    // public List <Permiso> listarActivos();
    public Permiso buscarPorID (long id);
    public void guardar (Permiso user);
    public List<Permiso> BuscarPermisoDni (long dni);
    
}
