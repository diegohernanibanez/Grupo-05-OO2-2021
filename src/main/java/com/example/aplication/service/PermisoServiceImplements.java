package com.example.aplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.aplication.entity.Lugar;
import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoPeriodo;
import com.example.aplication.repository.LugarRepository;
import com.example.aplication.repository.PermisoRepository;

@Service
public class PermisoServiceImplements implements IPermisoService {

    @Autowired
    private PermisoRepository permisoRepository;
    @Autowired
    private LugarRepository lugarRepository;

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

        if(hasta.isBefore(desde) || hasta.isEqual(desde)) throw new Exception("Fechas incorrectas");
        for (int i = 0 ; i < todos.size() ; i++)
            {
                Permiso p = todos.get(i);
                   if (((p.getFecha().isBefore(hasta) || p.getFecha().isEqual(hasta) ) && (p.getFecha().isAfter(desde)||p.getFecha().isEqual(desde))))
                   {rta.add(p);}
            }

        if(rta.isEmpty()) throw new Exception("No hay permisos para mostrar");
        return rta;
    }

    
    @Override
    public List<Permiso> filtrarPorFechaLugar(LocalDate desde, LocalDate hasta, String desdeLugar, String hastaLugar )throws Exception{
        List<Permiso> todos = filtrarPorFecha(desde, hasta);
        List<Permiso> rta = new ArrayList<>(); 
        List<Lugar> lugares = lugarRepository.findAll();
        Lugar desdel = new Lugar();
        Lugar hastal = new Lugar();
        boolean esta = false;
        boolean estaprimero = false;
        boolean estasegundo= false;

        // if(desdeLugar.isBlank()) esta= true;
        for (Lugar l : lugares ){
            if (l.getLugar().equals(desdeLugar)) {
                estaprimero = true;
                esta = true;
                desdel = l;
            }
        }


        // if (!(esta)) throw new Exception("lugar inexistente");
       
        // esta = false;
        if(desdeLugar.isBlank()) esta = true;
        for (Lugar l : lugares ){
            if (l.getLugar().equals(hastaLugar)) {
                estasegundo = true;
                esta = true;
                hastal=l;

            }
        }
        // if (!(esta)) throw new Exception("lugar inexistente");



        for (Permiso p : todos){
            if(estaprimero && estasegundo){if(p.getDesdeHasta().contains(desdel)&& p.getDesdeHasta().contains(hastal)) rta.add(p);}
            if (estaprimero && (!estasegundo)) {if(p.getDesdeHasta().contains(desdel)) rta.add(p);}
            if ((!estaprimero) && (estasegundo)) {if(p.getDesdeHasta().contains(hastal)) rta.add(p);}


            
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
