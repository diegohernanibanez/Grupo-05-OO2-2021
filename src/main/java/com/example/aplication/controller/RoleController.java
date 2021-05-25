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
@RequestMapping("/views/roles")

// tengo que mapear esto DIOS (roles es la carpeta)
public class RoleController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Secured({"ROLE_ADMIN","ROLE_AUDITOR"})
    @GetMapping("/")
    public String listarUsers(Model model) {
        List<Role> listadoRoles = roleService.listarTodos();
        model.addAttribute("titulo", "Lista de roles");
        model.addAttribute("role", listadoRoles);
        System.out.println(listadoRoles);

        // cambiar view
        return ViewRouteHelper.LISTAR_ROLES;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String crear(Model model) {

        Role role = new Role();
        List<User> listUser = userService.listarActivos();

        model.addAttribute("titulo", "Formulario: Nuevo Rol");
        model.addAttribute("role", role);
        model.addAttribute("user", listUser);
        

        /// cambiar viewRoute
        return ViewRouteHelper.CREAR_ROLES;
    }

    // ********************* ABM User ******************** */
    // Guardar User en BD
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Role role, BindingResult result, Model model,
            RedirectAttributes attributes) {


        List<User> listUser = userService.listarActivos();
        System.out.println("RESULT: " + result);
       
        if (result.hasErrors()) {
            
            model.addAttribute("titulo", "Formulario: Nuevo User");
            model.addAttribute("role", role);
            model.addAttribute("user", listUser);
            System.out.println("Errores en el formulario: ");
            
            // cambiar viewRoute
            return ViewRouteHelper.CREAR_ROLES;

        }

        role.setTipo(role.getTipo());

        roleService.guardar(role);
        System.out.println("Role Guardado: " + role);
        attributes.addFlashAttribute("success","Role guardado con exito");


        // cambiar view
        return ViewRouteHelper.REDIRECT_ROLE;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idRole, Model model, RedirectAttributes attributes) {

        Role role = null;
        if (idRole > 0) {
            role = roleService.buscarPorID(idRole);
        }
        if (role == null) {
            System.out.println("el id solicitado no existe");
            attributes.addFlashAttribute("error","*ERROR* el Rol solicitado no existe");
            
            //cambiar view
            return ViewRouteHelper.REDIRECT_ROLE;
        }

        List<User> listUser = userService.listarActivos();

        model.addAttribute("titulo", "Formulario: Editar Rol");
        model.addAttribute("rol", role);
        model.addAttribute("user", listUser);
      
        //cambiar view
        return ViewRouteHelper.CREAR_ROLES;
    }


    @Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idRole, RedirectAttributes attribute) {

		Role role = null;
		
		if (idRole > 0) {
            role = roleService.buscarPorID(idRole);
        }
        if (role == null) {
            System.out.println("el id solicitado no existe");
            attribute.addFlashAttribute("error","*ERROR* el rol solicitado no existe");
            return ViewRouteHelper.REDIRECT_ROLE;
        }
		
        roleService.eliminar(idRole);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return ViewRouteHelper.REDIRECT_ROLE;
	}



    // ********************* ABM User ******************** */

}
