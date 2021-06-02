package com.example.aplication.controller;

import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;

import com.example.aplication.entity.Persona;
import com.example.aplication.service.PermisoServiceImplements;
import com.example.aplication.service.PersonaServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BuscarController {

    @Autowired
    private PersonaServiceImplements personaServiceImplements;
    @Autowired
    private PermisoServiceImplements permisoServiceImplements;

    @RequestMapping("/buscar")
    public String viewHomePage(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarPersona";
    }

    @RequestMapping("/buscarMain")
    public String viewHomePage(Model model) {

        return "views/buscar/buscarPermisoMain";
    }

    @RequestMapping("/buscar/permiso")
    public String buscarPermisos(Model model, @Param("dni") Long dni) {
        Persona personaFind = personaServiceImplements.buscarPorDni(dni);
        List<Permiso> listPermisos = permisoServiceImplements.listarTodos();
        List<Permiso> listProducts = new ArrayList<Permiso>();

        System.out.println(listPermisos);

        for (Permiso permiso : listPermisos) {

            if (personaFind.getDni() == permiso.getPedido().getDni()) {

                if (permiso instanceof PermisoDiario) {

                    
                    
                    listProducts.add(permiso);
                    model.addAttribute("listProducts", listProducts);
                    model.addAttribute("dni", dni);
                    System.out.println(listProducts);
                    return "views/buscar/buscarPermisoDiario";

                } else {

                    model.addAttribute("listProducts", listProducts);
                    model.addAttribute("dni", dni);

                    return "views/buscar/buscarPermisoPeriodo";

                }

            }

        }

        return "views/buscar/buscarPermisoMain";

    }

    @RequestMapping("/buscar/permisoRodado")
    public String buscarPermisoRodado(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarRodado";
    }

    @RequestMapping("/buscar/permisoFecha")
    public String buscarPermisoFecha(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarFechaValida";
    }

}
