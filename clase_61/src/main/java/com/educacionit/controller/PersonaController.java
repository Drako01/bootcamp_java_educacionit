package com.educacionit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.educacionit.dto.AuthResponse;
import com.educacionit.model.Persona;

@Controller
@RequestMapping("/personas")
public class PersonaController {

	private List<Persona> personas = new ArrayList<>();

	@GetMapping(value = "/listar")
	public String personaListar(Model model) {
		if (personas.isEmpty()) {
			Persona unaPersona = new Persona("Nombre", 40, "Masculino");
			personas.add(unaPersona);
		}
		
		model.addAttribute("personas", personas);
		
		return "personas";
		
	}

}
