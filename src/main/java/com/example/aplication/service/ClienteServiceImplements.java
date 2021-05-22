package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.Cliente;
import com.example.aplication.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImplements implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {   
        return (List<Cliente>)clienteRepository.findAll();
    }

    @Override
    public void guardar(Cliente cliente) {
        clienteRepository.save(cliente);       
    }

    @Override
    public Cliente buscarPorID(long id) { 
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        clienteRepository.deleteById(id);
    }

    
}
