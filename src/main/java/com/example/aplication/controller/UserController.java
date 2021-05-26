package com.example.aplication.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.aplication.entity.Role;
import com.example.aplication.entity.User;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.IRoleService;
import com.example.aplication.service.IUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Secured({"ROLE_ADMIN","ROLE_AUDITOR"})
    @GetMapping("/")
    public String listarUsers(Model model) {
        List<User> listadoUsers = userService.listarActivos();
        model.addAttribute("titulo", "Lista de usuarios");
        model.addAttribute("user", listadoUsers);
        System.out.println(listadoUsers);
        return ViewRouteHelper.LISTAR;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String crear(Model model) {

        User user = new User();
        List<Role> listRoles = roleService.listarActivos();

        model.addAttribute("titulo", "Formulario: Nuevo User");
        model.addAttribute("user", user);
        model.addAttribute("role", listRoles);
        return ViewRouteHelper.CREAR;
    }

    // ********************* ABM User ******************** */
    // Guardar User en BD
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute User user, BindingResult result, Model model,
            RedirectAttributes attributes) {

        List<Role> listRoles = roleService.listarActivos();
        System.out.println("RESULT: " + result);
       
        if (result.hasErrors()) {
            
            model.addAttribute("titulo", "Formulario: Nuevo User");
            model.addAttribute("user", user);
            model.addAttribute("role", listRoles);
            System.out.println("Errores en el formulario: ");
            return ViewRouteHelper.CREAR;

        }
        user.setEnabled(true);
        user.setPassword(passEncoder.encode(user.getPassword()));

        userService.guardar(user);
        System.out.println("User Guardado: " + user);
        attributes.addFlashAttribute("success","User guardado con exito");

        return ViewRouteHelper.REDIRECT_CLIENTE;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idUser, Model model, RedirectAttributes attributes) {

        User user = null;
        if (idUser > 0) {
            user = userService.buscarPorID(idUser);
        }
        if (user == null) {
            System.out.println("el id solicitado no existe");
            attributes.addFlashAttribute("error","*ERROR* el User solicitado no existe");
            return ViewRouteHelper.REDIRECT_CLIENTE;
        }

        List<Role> listRoles = roleService.listarActivos();

        model.addAttribute("titulo", "Formulario: Editar User");
        model.addAttribute("user", user);
        model.addAttribute("role", listRoles);
       return ViewRouteHelper.CREAR;
    }

    @Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idUser, RedirectAttributes attribute) {

		User user = null;
		
		if (idUser > 0) {
            user = userService.buscarPorID(idUser);
        }
        if (user == null) {
            System.out.println("el id solicitado no existe");
            attribute.addFlashAttribute("error","*ERROR* el User solicitado no existe");
            return ViewRouteHelper.REDIRECT_CLIENTE;
        }
		
        user.setEnabled(false);
		userService.guardar(user);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return ViewRouteHelper.REDIRECT_CLIENTE;
	}



    // ********************* ABM User ******************** */

}
