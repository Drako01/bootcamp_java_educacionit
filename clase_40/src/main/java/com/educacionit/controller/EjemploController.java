package com.educacionit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.educacionit.model.Alumno;

@Controller
@RequestMapping("/ejemplo")
public class EjemploController {

	// http://localhost:8080/alumnos/metodo1
	@RequestMapping(value = "/metodo1", method = RequestMethod.GET)
	public String metodo1() {
		return "vista1";
	}

	@GetMapping("/metodo2")
	public ModelAndView metodo2() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Alumno unAlumnoCreado = new Alumno(1000, "Nombre de Alumno 1000");
		
		modelAndView.addObject("unAlumno", unAlumnoCreado  );
		
		modelAndView.setViewName("vista2");
		
		return modelAndView;
	}
	
	
	// http://localhost:8080/alumnos/metodo3?legajo=555&nombre=UnNombreDeAlumno
	@GetMapping("/metodo3")
	public ModelAndView metodo3(@RequestParam(name="legajo") Integer unLegajo, @RequestParam(name="nombre") String unNombre) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Alumno unAlumnoCreado = new Alumno(unLegajo, unNombre);
		
		modelAndView.addObject("unAlumno", unAlumnoCreado  );
		
		modelAndView.setViewName("vista3");
		
		return modelAndView;
	}
	

}
