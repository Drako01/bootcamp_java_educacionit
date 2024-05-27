package com.educacionit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Alumno;
import com.educacionit.repository.AlumnoRepository;
import com.educacionit.service.AlumnoService;

@SpringBootTest
class AlumnoServiceImplTest {

	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Test
	void testGetAllAlumnos() {
		
		List<Alumno> todosLosalumnos = alumnoService.getAllAlumnos();
		assertNotNull(todosLosalumnos);		
	}

	@Test
	void testGetById() throws Exception {
		// Crear un alumno		
		Alumno unAlumno = new Alumno("Nombre Alumno en Test", 1000);
		Alumno unAlumnoGuardado = alumnoRepository.save(unAlumno);
		
		// Buscar por Id - En capa de Servicio
		Alumno elAlumnoBuscado = alumnoService.getById(unAlumnoGuardado.getId());
		
		assertNotNull(elAlumnoBuscado);
		assertEquals(unAlumnoGuardado.getId(), elAlumnoBuscado.getId());
		assertEquals(unAlumnoGuardado.getNombre(), elAlumnoBuscado.getNombre());
		assertEquals(unAlumnoGuardado.getLegajo(), elAlumnoBuscado.getLegajo());
				
		// Limpieza - Borrar el caso creado
		alumnoRepository.deleteById(unAlumnoGuardado.getId());
		
	}

	@Test
	void testSaveAlumno() {
		Alumno alumnoAGuardar = new Alumno("Nombre Alumno en Test", 1000);
		
		Alumno alumnoGuardado = alumnoService.saveAlumno(alumnoAGuardar);
		
		assertNotNull(alumnoGuardado);
		assertNotNull(alumnoGuardado.getId());
		
		// Limpieza - Borrar el caso creado
		alumnoRepository.deleteById(alumnoGuardado.getId());

	}

	@Test
	void testDeteleAlumno() {
	}

}
