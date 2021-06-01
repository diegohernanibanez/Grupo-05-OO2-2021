package com.example.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
