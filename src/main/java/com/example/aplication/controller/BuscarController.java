package com.example.aplication.controller;

import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;
import com.example.aplication.entity.PermisoPeriodo;
import com.example.aplication.entity.Persona;
import com.example.aplication.entity.Rodado;
import com.example.aplication.service.PermisoServiceImplements;
import com.example.aplication.service.PersonaServiceImplements;
import com.example.aplication.service.RodadoServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/buscar")
public class BuscarController {

    @Autowired
    private PersonaServiceImplements personaServiceImplements;
    @Autowired
    private PermisoServiceImplements permisoServiceImplements;
    @Autowired
    private RodadoServiceImplements rodadoServiceImplements;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarPersona";
    }

    @RequestMapping("/permiso/persona")
    public String viewHomePage(Model model) {

        return "views/buscar/buscarPermisoMain";
    }

    @RequestMapping("/permiso/")
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

    @RequestMapping("/permiso/rodadoMain")
    public String viewHomeRodado(Model model) {

        return "views/buscar/buscarRodadoMain";
    }

    @RequestMapping("/permiso/rodado/")
    public String buscarPermisoRodado(Model model, @Param("dominio") String dominio,  RedirectAttributes attributes) {

        Rodado rodado = rodadoServiceImplements.buscarDomino(dominio);

        List<Permiso> listPermisos = permisoServiceImplements.listarTodos();
        List<Permiso> listProducts = new ArrayList<Permiso>();


        System.out.println(rodado);

        System.out.println();

        if(rodado == null){
        
                attributes.addFlashAttribute("error", "Rodado no Encontrado"); //<- no funciona
                return "redirect:permiso/rodadoMain";
            }
    
           

            for (Permiso permiso : listPermisos) {

                System.out.println(permiso.getPedido().getNombre());

                if (permiso instanceof PermisoPeriodo) {
                    if(((PermisoPeriodo) permiso).getRodado().getDominio() == rodado.getDominio()){
                        listProducts.add(permiso);
                        model.addAttribute("listProducts", listProducts);
                        model.addAttribute("dominio", dominio);
                        return "views/buscar/buscarRodado";
                    }
                    
                }
            }
        return "views/buscar/buscarRodado";

 
    }

    @RequestMapping("/permiso/fecha")
    public String buscarPermisoFecha(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarFechaValida";
    }

}
