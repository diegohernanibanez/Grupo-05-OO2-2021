package com.example.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PermisoController {
	
	@GetMapping ({"/seleccionPermiso"})
	public String eleccionPermiso() {
		return "views/permiso/EleccionPermiso";
	}

	@GetMapping ({"/permisoPeriodo"})
	public String permisoPeriodo() {
		return "views/permiso/FormularioPermisoP";
	}

	@GetMapping ({"/permisoDiario"})
	public String permisoDiario() {
		return "views/permiso/FormularioPermisoD";
	}

	@GetMapping ({"/permiso1"})
	public String form1() {
		return "views/permiso/FormularioPermisoDmatias";
	}



}
