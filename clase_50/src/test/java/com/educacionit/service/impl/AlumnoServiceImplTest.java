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
		List<Alumno> todosLosAlumnos = alumnoService.getAllAlumnos();
		assertNotNull(todosLosAlumnos);
	}

	@Test
	void testGetById() throws Exception {
		Alumno unAlumno = new Alumno("Nombre", 1000);
		Alumno unAlumnoGuardado = alumnoRepository.save(unAlumno);
		Alumno elAlumnoBuscado = alumnoService.getById(unAlumnoGuardado.getId());
		assertNotNull(elAlumnoBuscado);
		assertEquals(unAlumnoGuardado.getId(), elAlumnoBuscado.getId());
		assertEquals(unAlumnoGuardado.getNombre(), elAlumnoBuscado.getNombre());
		assertEquals(unAlumnoGuardado.getLegajo(), elAlumnoBuscado.getLegajo());
		alumnoRepository.deleteById(unAlumnoGuardado.getId());		
	}

	@Test
	void testSaveAlumno() {
		Alumno alumnoAGuardar = new Alumno("Nombre", 1000);
		Alumno elAlumnoGuardado = alumnoRepository.save(alumnoAGuardar);
		assertNotNull(elAlumnoGuardado);
		assertNotNull(elAlumnoGuardado.getId());
		alumnoRepository.deleteById(elAlumnoGuardado.getId());		
	}

	@Test
	void testDeleteAlumno() {
		Alumno alumnoAGuardar = new Alumno("Nombre", 1000);
		Alumno elAlumnoGuardado = alumnoRepository.save(alumnoAGuardar);
		assertNotNull(elAlumnoGuardado);
		alumnoRepository.deleteById(elAlumnoGuardado.getId());	
		
	}

}
