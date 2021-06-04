package com.example.aplication.controller;

import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;

import com.example.aplication.entity.Persona;
import com.example.aplication.service.PermisoServiceImplements;
import com.example.aplication.service.PersonaServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/buscar")
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

    // @RequestMapping("/permiso/rodado")
    // public String buscarPermisoRodado(Model model, @Param("dominio") String dominio) {
    //     List<Persona> listProducts = personaServiceImplements.listarDni(dni);
    //     model.addAttribute("listProducts", listProducts);
    //     model.addAttribute("dni", dni);

    //     return "views/buscar/buscarRodado";
    // }

    @ModelAttribute
    LocalDate initLocalDate() {
        return LocalDate.now();
    }

    @RequestMapping(value = "/permiso/fecha", method = RequestMethod.GET)
    public String viewsBuscarFecha(Model model) {
        model.addAttribute("desde" , LocalDate.now().toString());
        model.addAttribute("hasta", LocalDate.now().toString());
        return "views/buscar/buscarfechaValida";
    }

    @RequestMapping(value = "/permiso/buscarFecha", method = RequestMethod.POST)
    public String returnBuscarFecha(@ModelAttribute("hasta")String hasta, @ModelAttribute("desde")String desde,  Model model, RedirectAttributes attribute) {
       
        List<Permiso> lPermisos = permisoServiceImplements.listarTodos();
        String[] hastas = hasta.split("-");
        String[] desdes = desde.split("-");

        LocalDate tope =  LocalDate.of( Integer.parseInt(hastas[0]), Integer.parseInt(hastas[1]), Integer.parseInt(hastas[2]));
        LocalDate inicio =  LocalDate.of( Integer.parseInt(desdes[0]), Integer.parseInt(desdes[1]), Integer.parseInt(desdes[2]));
        
        if(tope.isBefore(inicio) || tope.equals(inicio)){
            attribute.addFlashAttribute("error", "Ingrese las fechas correctas");
            return "redirect:/buscar/permiso/fecha";
        }
       
            for (int i = 0 ; i < lPermisos.size() ; i++)
            {
                if( lPermisos.get(i).getFecha().isAfter(tope)) lPermisos.remove(i);
                if( lPermisos.get(i).getFecha().isBefore(inicio)) lPermisos.remove(i); 

            }
        
        
        if((lPermisos.get(0).getFecha().isAfter(tope) && (lPermisos.size() == 1))|| (lPermisos.get(0).getFecha().isBefore(inicio) && (lPermisos.size() == 1)))
        {attribute.addFlashAttribute("warning", "No hay permisos en esas fechas");
        return "redirect:/buscar/permiso/fecha";}

        model.addAttribute("listProducts", lPermisos);
        return "views/buscar/buscarfechaValida";
    }


}
 