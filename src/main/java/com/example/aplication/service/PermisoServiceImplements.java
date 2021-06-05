package com.example.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoPeriodo;
import com.example.aplication.repository.PermisoRepository;

@Service
public class PermisoServiceImplements implements IPermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Override
    public List<Permiso> listarTodos() {
        return (List<Permiso>) permisoRepository.findAll();
    }

    @Override
    public List<Permiso> listarActivos(){
        List<Permiso> todos = listarTodos();
        List<Permiso> rta = new ArrayList<>();
        for (int i = 0 ; i < todos.size() ; i++){
            Permiso p = todos.get(i);
                if (p instanceof PermisoPeriodo){
                   if ((p.getFecha().plusDays(((PermisoPeriodo)p).getCantDias()).isAfter(LocalDate.now()) || (p.getFecha().plusDays(((PermisoPeriodo)p).getCantDias()).isEqual(LocalDate.now())))){
                         rta.add(p);    
                    }
                }else{
                    if ((p.getFecha().plusDays(1).isAfter(LocalDate.now()) || p.getFecha().plusDays(1).isEqual(LocalDate.now()) )){
                        rta.add(p);
                    }
                }
        }
        return rta;
    }

    @Override
    public List<Permiso> filtrarPorFecha(LocalDate desde, LocalDate hasta) throws Exception{
        List<Permiso> todos = listarActivos();
        List<Permiso> rta = new ArrayList<>(); 

        if(hasta.isBefore(desde)) throw new Exception("Desde mayor que hasta");
        for (int i = 0 ; i < todos.size() ; i++)
            {
                Permiso p = todos.get(i);
                   if (((p.getFecha().isBefore(hasta) || p.getFecha().isEqual(hasta) ) && (p.getFecha().isAfter(desde)||p.getFecha().isEqual(desde))))
                   {rta.add(p);}
            }
        return rta;
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
