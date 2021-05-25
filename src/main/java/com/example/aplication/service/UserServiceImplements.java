package com.example.aplication.service;

import java.util.List;

import com.example.aplication.entity.User;
import com.example.aplication.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplements implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> listarTodos() {   
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<User> listarActivos() {   
        return (List<User>)userRepository.findByEnabledTrue();
    }

    @Override
    public void guardar(User user) {
        userRepository.save(user);       
    }

    @Override
    public User buscarPorID(long id) { 
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(long id) {
        userRepository.deleteById(id);
    }

    
}
