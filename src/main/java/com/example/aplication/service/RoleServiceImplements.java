package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Role;
import com.example.aplication.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplements implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> listaRoles() {
        
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public List<Role> listarTodos() {   
        return (List<Role>)roleRepository.findAll();
    }

    @Override
    public void guardar (Role user) {
        roleRepository.save(user);       
    }

    @Override
    public Role buscarPorID(long id) { 
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        roleRepository.deleteById(id);
    }

    
}
