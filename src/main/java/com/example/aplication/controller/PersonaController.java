package com.example.aplication.controller;

import java.util.List;

import com.example.aplication.entity.Persona;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.IPersonaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/views/personas")
public class PersonaController {


    @Autowired 
    private IPersonaService personaService; 

    @GetMapping("/")
    public String listarPersonas(Model model) {
        List<Persona> listadoPersonas = personaService.listarTodos();
        model.addAttribute("titulo", "Lista de personas");
        model.addAttribute("persona", listadoPersonas);
        System.out.println(listadoPersonas);

        // cambiar view
        return ViewRouteHelper.LISTAR_PERSONAS;
    }

   
    

    
}
