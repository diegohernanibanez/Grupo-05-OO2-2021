package com.example.aplication.controller;

import javax.validation.Valid;

import com.example.aplication.entity.Lugar;
import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;

import com.example.aplication.service.ILugarService;
import com.example.aplication.service.IPermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
// @RequestMapping("/views/permiso")
public class PermisoController {

    @Autowired
    private IPermisoService permisoService;

    @Autowired
    private ILugarService lugarService;

    @GetMapping({ "/seleccionPermiso" })
    public String eleccionPermiso() {
        return "/views/permiso/EleccionPermiso";
    }

    @GetMapping({ "/permisoPeriodo" })
    public String permisoPeriodo() {
        return "views/permiso/FormularioPermisoP";
    }

    @GetMapping({ "/crearPermisoDiario" })
    public String permisoDiario(Model model) {
        Permiso permiso = new PermisoDiario();

        List<Lugar> listLugares = lugarService.listarTodos();
        System.out.println(listLugares);
        model.addAttribute("desdeHasta", listLugares);

        model.addAttribute("titulo", "Formulario: Nuevo Permiso");

        model.addAttribute("permiso", permiso);
        return "views/permiso/FormularioPermisoD";
    }

    @PostMapping("/savePermisoDiario")
    public String guardar(@Valid @ModelAttribute PermisoDiario permiso, BindingResult result, Model model,
            RedirectAttributes attributes) {

        System.out.println("RESULT: " + result);

        if (result.hasErrors()) {

            model.addAttribute("titulo", "Formulario: Nuevo Permiso");
            model.addAttribute("permiso", permiso);
            System.out.println("Errores en el formulario: ");

            // cambiar viewRoute
            return "views/permiso/FormularioPermisoD";

        }

        model.addAttribute("titulo", "Lista de roles");

        permisoService.guardar(permiso);
        System.out.println("Permiso Guardado: " + permiso);
        attributes.addFlashAttribute("success", "Permiso guardado con exito");

        // cambiar view
        return "redirect:/home";
    }

    @GetMapping({ "/permiso1" })
    public String form1() {
        return "views/permiso/FormularioPermisoDmatias";
    }

}
