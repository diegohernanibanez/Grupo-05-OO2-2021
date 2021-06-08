package com.example.aplication.service;

import java.time.LocalDate;
import java.util.List;

import com.example.aplication.entity.Permiso;

public interface IPermisoService {

    public List <Permiso> listarTodos();
    public List <Permiso> listarActivos();
    public Permiso buscarPorID (long id);
    public Permiso buscarPorDniTipo(long dni, String tipo);
    public void guardar (Permiso user);
    public List<Permiso> BuscarPermisoDni (long dni);
    public List<Permiso> filtrarPorFecha(LocalDate desde, LocalDate hasta) throws Exception;
    public List<Permiso> filtrarPorFechaLugar(LocalDate desde, LocalDate hasta, String desdeLugar, String hastaLugar ) throws Exception;
    
    
}
