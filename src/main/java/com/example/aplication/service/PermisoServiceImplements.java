package com.example.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.aplication.entity.Lugar;
import com.example.aplication.entity.Permiso;
import com.example.aplication.repository.PermisoRepository;

@Service
public class PermisoServiceImplements implements IPermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<Permiso> listarTodos() {
        return (List<Permiso>) permisoRepository.findAll();
    }

    // @Override
    // public List<Permiso> listarActivos() {
    // return (List<Permiso>)permisoRepository.findByEnabledTrue();

    // }

    @Override
    public List<Permiso> filtrarPorFecha(LocalDate desde, LocalDate hasta) throws Exception{
        List<Permiso> todos = listarTodos();

        if(hasta.isBefore(desde)) throw new Exception("Desde mayor que hasta");
        for (int i = 0 ; i < todos.size() ; i++)
            {
                if( todos.get(i).getFecha().isAfter(hasta)) todos.remove(i);
                if( todos.get(i).getFecha().isBefore(desde)) todos.remove(i); 

            }
        if((todos.get(0).getFecha().isAfter(hasta) && (todos.size() == 1))|| (todos.get(0).getFecha().isBefore(desde) && (todos.size() == 1)))
         { throw new Exception("No se encontraron permisos");}

        return todos;
    }

  
    

    @Override
    public Permiso buscarPorID(long id) {
        return permisoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Permiso user) {
        permisoRepository.save(user);
    }

    @Override
    public List<Permiso> BuscarPermisoDni(long dni) {
        
        return permisoRepository.findByPedidoDni(dni);
    }

}
