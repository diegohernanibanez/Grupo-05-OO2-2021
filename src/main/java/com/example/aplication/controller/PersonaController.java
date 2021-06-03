package com.example.aplication.controller;


import java.util.List;

import javax.validation.Valid;

import com.example.aplication.entity.Persona;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.IPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("create")
    public String crear(Model model) {

        Persona persona = new Persona();
        model.addAttribute("titulo", "Formulario: Nueva Persona");
        model.addAttribute("persona", persona);

        /// cambiar viewRoute
        return ViewRouteHelper.CREAR_PERSONAS;
    }

    // ********************* ABM User ******************** */
    // Guardar User en BD
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Persona persona, BindingResult result, Model model,
            RedirectAttributes attributes) {

        System.out.println("RESULT: " + result);

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario: Nueva Persona");
            model.addAttribute("persona", persona);
            System.out.println("Errores en el formulario: ");

            // cambiar viewRoute
            return ViewRouteHelper.CREAR_PERSONAS;

        }


        personaService.guardar(persona);
        System.out.println("Persona Guardada: " + persona);
        attributes.addFlashAttribute("success", "Persona guardada con exito");

        // cambiar view
        return ViewRouteHelper.REDIRECT_PERSONA;
    }


}
