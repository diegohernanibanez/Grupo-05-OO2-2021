package com.example.aplication.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.aplication.entity.Ciudad;
import com.example.aplication.entity.Cliente;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.ICiudadService;
import com.example.aplication.service.IClienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@RequestMapping("/views/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;
    @Autowired
    private ICiudadService ciudadService;

    @Secured({"ROLE_ADMIN","ROLE_USER"})
    @GetMapping("/")
    public String listarClientes(Model model) {
        List<Cliente> listadoClientes = clienteService.listarTodos();
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("clientes", listadoClientes);
        return ViewRouteHelper.LISTAR;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("create")
    public String crear(Model model) {

        Cliente cliente = new Cliente();
        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario: Nuevo Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listCiudades);
        return ViewRouteHelper.CREAR;
    }

    // ********************* ABM Cliente ******************** */
    // Guardar Cliente en BD
    @Secured("ROLE_ADMIN")
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model,
            RedirectAttributes attributes) {

        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        if (result.hasErrors()) {
            
            model.addAttribute("titulo", "Formulario: Nuevo Cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listCiudades);
            System.out.println("Errores en el formulario: ");
            return ViewRouteHelper.CREAR;

        }
        clienteService.guardar(cliente);
        System.out.println("Cliente Guardado: " + cliente);
        attributes.addFlashAttribute("success","Cliente guardado con exito");

        return ViewRouteHelper.REDIRECT_CLIENTE;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Long idCliente, Model model, RedirectAttributes attributes) {

        
        Cliente cliente = null;
        if (idCliente > 0) {
            cliente = clienteService.buscarPorID(idCliente);
            if (cliente == null) {
                System.out.println("el id solicitado no existe");
                attributes.addFlashAttribute("error","*ERROR* el Cliente solicitado no existe");
                return ViewRouteHelper.REDIRECT_CLIENTE;
            }
        } else {
            System.out.println("el id solicitado no existe");
            attributes.addFlashAttribute("error","*ERROR* el Cliente solicitado no existe");
            return ViewRouteHelper.REDIRECT_CLIENTE;
        }

        List<Ciudad> listCiudades = ciudadService.listaCiudades();

        model.addAttribute("titulo", "Formulario: Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listCiudades);
       return ViewRouteHelper.CREAR;
    }

    @Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long idCliente, RedirectAttributes attribute) {

		Cliente cliente = null;
		
		if (idCliente > 0) {
			cliente = clienteService.buscarPorID(idCliente);
			
			if (cliente == null) {
				System.out.println("Error: El ID del cliente no existe!");
				attribute.addFlashAttribute("error", "ATENCION: El ID del cliente no existe!");
				return ViewRouteHelper.REDIRECT_CLIENTE;
			}
		}else {
			System.out.println("Error: Error con el ID del Cliente");
			attribute.addFlashAttribute("error", "ATENCION: Error con el ID del Cliente!");
			return ViewRouteHelper.REDIRECT_CLIENTE;
		}		
		
		clienteService.eliminar(idCliente);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Exito!");

		return ViewRouteHelper.REDIRECT_CLIENTE;
	}



    // ********************* ABM Cliente ******************** */

}
