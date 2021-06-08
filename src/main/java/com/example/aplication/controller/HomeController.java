package com.example.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping ({"/","/home","/index"})
	public String index() {
		return "index";
	}

	@GetMapping ("/form")
	public String form() {
		return "/views/permiso/formularioPermiso";
	}

}
