package com.example.aplication.controller;

import javax.validation.Valid;

import com.example.aplication.entity.Lugar;
import com.example.aplication.entity.Permiso;
import com.example.aplication.entity.PermisoDiario;
import com.example.aplication.entity.Persona;
import com.example.aplication.helper.ViewRouteHelper;
import com.example.aplication.service.ILugarService;
import com.example.aplication.service.IPermisoService;
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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/permiso")
public class PermisoController {

    @Autowired
    private IPermisoService permisoService;
    @Autowired
    private IPersonaService personaService;
    @Autowired
    private ILugarService lugarService;

    @GetMapping({ "/" })
    public String seleccionPermiso() {
        return ViewRouteHelper.SELECCION_PERMISO;
    }

    @GetMapping({ "/periodo/create" })
    public String permisoPeriodo() {
        return ViewRouteHelper.CREAR_PERMISO_PERIODO;
    }

    @GetMapping({ "/diario/create" })
    public String permisoDiario(Model model) {
        Permiso permiso = new PermisoDiario();
        Persona persona = new Persona();
        List<Lugar> listLugares = lugarService.listarTodos();
        String motivo = "";

        model.addAttribute("desdeHasta", listLugares);
        model.addAttribute("titulo", "Formulario: Nuevo Permiso");
        model.addAttribute("motivo", motivo);
        model.addAttribute("pedido",persona);
        model.addAttribute("permiso", permiso);
        
        return ViewRouteHelper.CREAR_PERMISO_DIARIO;
    }

    @PostMapping("/diario/save")
    public String guardar(@Valid @ModelAttribute PermisoDiario permiso, BindingResult result, Model model,
            RedirectAttributes attributes) {
        
        System.out.println("RESULT" + result);


        // List<Lugar> listLugares = lugarService.listarTodos();
        // if (result.hasErrors()) {
        //     model.addAttribute("desdeHasta", listLugares);
        //     model.addAttribute("titulo", "Formulario: Nuevo Permiso");
        //     model.addAttribute("permiso", permiso);
        //     return ViewRouteHelper.CREAR_PERMISO_DIARIO;
        // }

        permiso.setFecha(LocalDate.now());

        //buscamos persona. Si no existe, Tira error 
        Persona persona = personaService.buscarPorDni(permiso.getPedido().getDni());
        
        if(persona != null) {
            permiso.setPedido(persona);
        } else {
            attributes.addFlashAttribute("error", "Ese documento no se encuentra en la base de datos.");
            return ViewRouteHelper.REDIRECT_PERMISO_DIARIO_CREAR;
        }

        if(permiso.getMotivo().isEmpty()){
            attributes.addFlashAttribute("error", "El motivo esta vacio");
            return ViewRouteHelper.REDIRECT_PERMISO_DIARIO_CREAR;
        }
        permisoService.guardar(permiso);
        attributes.addFlashAttribute("success", "Permiso guardado con exito");

        // cambiar view
        return ViewRouteHelper.HOME_ROOT;
    }

}
