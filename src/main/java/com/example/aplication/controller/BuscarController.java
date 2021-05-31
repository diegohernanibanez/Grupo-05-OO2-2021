package com.example.aplication.controller;

import com.example.aplication.entity.Persona;
import com.example.aplication.service.PersonaServiceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BuscarController {

    @Autowired
    private PersonaServiceImplements personaServiceImplements;

    @RequestMapping("/buscar")
    public String viewHomePage(Model model, @Param("dni") Long dni) {
        List<Persona> listProducts = personaServiceImplements.listarDni(dni);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("dni", dni);

        return "views/buscar/buscarPersona";
    }




}
