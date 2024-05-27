package com.educacionit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.educacionit.exception.AlumnoNotFoundException;
import com.educacionit.model.Alumno;
import com.educacionit.model.Materia;
import com.educacionit.model.Pais;
import com.educacionit.model.Sexo;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	private List<Alumno> alumnos = new ArrayList<>();
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("alumnos", alumnos);
		model.addAttribute("sexo", Sexo.values());
		model.addAttribute("materia", Materia.values());
		model.addAttribute("pais", Pais.values());
		return "list";
	}

	@GetMapping("/list")
	@ResponseBody
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	@PostMapping("/add")
	@ResponseBody
	public String addAlumno(@RequestBody Alumno alumno) {
		alumnos.add(alumno);
		return "Alumno Agregado";
	}

	@PostMapping("/modify")
	@ResponseBody
	public String modifyAlumno(@RequestBody Alumno alumnoModificado) {

		try {
			Integer indice = findAlumnoIndexByLegajo(alumnoModificado.getLegajo());
			alumnos.set(indice, alumnoModificado);
			return "Alumno Agregado";

		} catch (Exception e) {
			return "Alumno no Encontrado";
		}
	}

	@PostMapping("/delete")
	@ResponseBody
	public String deleteAlumno(@RequestBody Integer legajo) {

		try {
			Integer indice = findAlumnoIndexByLegajo(legajo);
			alumnos.remove(indice);
			return "Alumno eliminado";
		} catch (Exception e) {
			return "Alumno no encontrado";
		}

	}

	private Integer findAlumnoIndexByLegajo(Integer legajo) throws AlumnoNotFoundException {

		for (int indice = 0; indice < alumnos.size(); indice++) {

			Alumno unAlumno = alumnos.get(indice);

			if (unAlumno.getLegajo().equals(legajo)) {
				return indice;
			}
		}

		throw new AlumnoNotFoundException("No se pudo encontrar el Alumno con legajo " + legajo);
	}
}
