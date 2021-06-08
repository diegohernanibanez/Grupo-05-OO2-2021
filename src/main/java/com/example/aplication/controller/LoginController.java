package com.example.aplication.controller;

import java.security.Principal;

import com.example.aplication.helper.ViewRouteHelper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout?", required = false)  String logout, 
            Model model, Principal principal,
            RedirectAttributes attribute) {

        String url = ViewRouteHelper.LOGIN;
        if (error != null) {
            model.addAttribute("error", "USUARIO O CONTRASEÑA INCORRECTOS");
        }
        if (principal != null) {
            attribute.addFlashAttribute("warning", "Usted ya ha inicidado sesion");
            url = "redirect:/index";
        }



        return url;
    }

    @GetMapping("/logout")
    public String logout(RedirectAttributes attribute) {

        attribute.addFlashAttribute("success", "Sesion finalizada con exito");
        return "redirect:/index";
    }
}
