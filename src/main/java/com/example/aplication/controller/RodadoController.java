package com.example.aplication.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.aplication.entity.Rodado;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.IRodadoService;


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
@RequestMapping("/rodados")
public class RodadoController {

    @Autowired
    private IRodadoService rodadoService;

    @GetMapping("/create")
    public String crear(Model model) {

        Rodado rodado = new Rodado();

        model.addAttribute("titulo", "Formulario: Nuevo rodado");
        model.addAttribute("rodado", rodado);
        return ViewRouteHelper.CREAR_RODADO;
    }


    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Rodado rodado, BindingResult result, Model model,
            RedirectAttributes attributes) {
       
        if (result.hasErrors()) {
            
            model.addAttribute("titulo", "Formulario: Nuevo rodado");
            model.addAttribute("rodado", rodado);
            System.out.println("Errores en el formulario: ");
            return ViewRouteHelper.CREAR_RODADO;
        }

        rodadoService.guardar(rodado);
        attributes.addFlashAttribute("success","Rodado guardado con exito");

        return ViewRouteHelper.REDIRECT_RODADO;
    }


}
