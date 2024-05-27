package com.educacionit.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;
import com.educacionit.entity.Inscripcion;
import com.educacionit.repository.AlumnoRepository;
import com.educacionit.repository.CursoRepository;
import com.educacionit.repository.InscripcionRespository;
import com.educacionit.service.InscripcionService;

@SpringBootTest
class InscripcionServiceImplTest {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private InscripcionService inscripcionService;
	
	@Autowired
	private InscripcionRespository inscripcionRespository;
	
	
	private static final String NOMBRE_ALUMNO = "Nombre Alumno TEST";
	private static final Integer LEGAJO_ALUMNO = 7534;	
	private static final String DESCRIPCION_CURSO = "NOMBRE CURSO TEST";

	@Test
	void testInscribirAlumno() {

		// A.- Pre condiciones del test
		// 1.- Cargar un Alumno
		// 2.- Cargar un Curso
		
		Alumno unAlumno = new Alumno(NOMBRE_ALUMNO, LEGAJO_ALUMNO);	// Creo la entidad
		alumnoRepository.save(unAlumno);							// Persistir un Alumno
		
		Curso unCurso = new Curso(DESCRIPCION_CURSO);	// Creo la entidad Curso
		cursoRepository.save(unCurso);					// Persistir un Curso		
		
		
		// B.- TEST
		inscripcionService.inscribirAlumno(unAlumno, unCurso);	// Inserto la inscripcion en la tabla 
		
		Inscripcion unaInscripcion = inscripcionRespository.findByAlumnoAndCurso(unAlumno, unCurso);
		
		assertNotNull(unaInscripcion);
		assertNotNull(unaInscripcion.getId());
		
		assertNotNull(unaInscripcion.getAlumno());
		assertEquals(unAlumno.getId(), unaInscripcion.getAlumno().getId());
		assertEquals(NOMBRE_ALUMNO, unaInscripcion.getAlumno().getNombre());
		assertEquals(LEGAJO_ALUMNO, unaInscripcion.getAlumno().getLegajo());
		
		assertNotNull(unaInscripcion.getCurso());
		assertEquals(unCurso.getId(), unaInscripcion.getCurso().getId());
		assertEquals(DESCRIPCION_CURSO, unaInscripcion.getCurso().getDescripcion());
		
		
		

		// C.- Post Condicion (Limpieza)
		// 1.- Borrar la inscripcion
		// 2.- Borrar un Curso
		// 3.- Borrar un alumno
		inscripcionRespository.delete(unaInscripcion);
		cursoRepository.delete(unCurso);
		alumnoRepository.delete(unAlumno);
		

	}

	@Test
	void testEliminarInscripcion() {
		
		// A.- Pre carga del Test
		Alumno unAlumno = new Alumno(NOMBRE_ALUMNO, LEGAJO_ALUMNO);	// Creo la entidad
		alumnoRepository.save(unAlumno);							// Persistir un Alumno
		
		Curso unCurso = new Curso(DESCRIPCION_CURSO);	// Creo la entidad Curso
		cursoRepository.save(unCurso);					// Persistir un Curso
		
		Inscripcion unaInscripcion = new Inscripcion(unAlumno, unCurso);
		inscripcionRespository.save(unaInscripcion);
		
		// B. -Test
		
		try {
			inscripcionService.eliminarInscripcion(unAlumno, unCurso);
			
		} catch (Exception e) {
			fail("No se pudo eliminar la inscripcion del alumno: " + unAlumno + ", con curso: " + unCurso);
		}
		
		Inscripcion inscripcionEnDB = inscripcionRespository.findByAlumnoAndCurso(unAlumno, unCurso);
		
		assertNull(inscripcionEnDB);
		

		// C.- Limpieza
		//inscripcionRespository.delete(unaInscripcion);
		cursoRepository.delete(unCurso);
		alumnoRepository.delete(unAlumno);
		
	}

}
