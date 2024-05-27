package com.educacionit.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;
import com.educacionit.entity.Inscripcion;
import com.educacionit.model.AlumnoConCursosDTO;
import com.educacionit.repository.AlumnoRepository;
import com.educacionit.repository.CursoRepository;
import com.educacionit.repository.InscripcionRespository;
import com.educacionit.service.AlumnoConCursosService;

@SpringBootTest
class AlumnoConCursosServiceImplTest {

	/*@Autowired
	private AlumnoConCursosRepository alumnoConCursosRepository;*/
	@Autowired
	private AlumnoRepository alumnoRepository;	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private InscripcionRespository inscripcionRespository;
	
	@Autowired
	private AlumnoConCursosService alumnoConCursosService;
	
	
	private static final String NOMBRE_ALUMNO = "Nombre Alumno TEST";
	private static final Integer LEGAJO_ALUMNO = 7534;
	
	private static final String DESCRIPCION_CURSO_01 = "NOMBRE CURSO TEST 01";
	private static final String DESCRIPCION_CURSO_02 = "NOMBRE CURSO TEST 02";

	private Alumno unAlumno;
	Curso cursoUno;
	Curso cursoDos;
	Inscripcion inscripcionUno;
	Inscripcion inscripcionDos;
	
	@BeforeEach
	void setUp() {		
		unAlumno = new Alumno(NOMBRE_ALUMNO, LEGAJO_ALUMNO);
		alumnoRepository.save(unAlumno);
		
		cursoUno = new Curso(DESCRIPCION_CURSO_01); 
		cursoDos = new Curso(DESCRIPCION_CURSO_02); 
		cursoRepository.save(cursoUno);
		cursoRepository.save(cursoDos);
		
		inscripcionUno = new Inscripcion(unAlumno, cursoUno);
		inscripcionDos = new Inscripcion(unAlumno, cursoDos);
		inscripcionRespository.save(inscripcionUno);		
		inscripcionRespository.save(inscripcionDos);		
	}
	
	@AfterEach
	void tearDown() {
		inscripcionRespository.delete(inscripcionUno);
		inscripcionRespository.delete(inscripcionDos);
		
		cursoRepository.delete(cursoUno);
		cursoRepository.delete(cursoDos);
		
		alumnoRepository.delete(unAlumno);
	}
	
	
	@Test
	void testGetAlumnoConCursosById() {
		
		AlumnoConCursosDTO unAlumnoConCursosDTO = null;
		
		try {
			unAlumnoConCursosDTO = alumnoConCursosService.getAlumnoConCursosById(unAlumno.getId());
			
		} catch (Exception e) {
			fail("No se puedo obtener el Alumno con sus cursos con Id: " + unAlumno.getId());
		}
		assertNotNull(unAlumnoConCursosDTO);
		assertNotNull(unAlumnoConCursosDTO.getCursos());
		
		
		List<String> cursos = unAlumnoConCursosDTO.getCursos();
		for (String curso : cursos) {
			System.out.println(curso);
		}
		
		assertTrue(unAlumnoConCursosDTO.getCursos().contains(DESCRIPCION_CURSO_01));
		assertTrue(unAlumnoConCursosDTO.getCursos().contains(DESCRIPCION_CURSO_02));
		
	}
	
	

}
