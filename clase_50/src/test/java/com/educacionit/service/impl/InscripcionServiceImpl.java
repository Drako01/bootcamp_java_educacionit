package com.educacionit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;
import com.educacionit.entity.Inscripcion;
import com.educacionit.repository.InscripcionRepository;
import com.educacionit.service.InscripcionService;

public class InscripcionServiceImpl implements InscripcionService {
	
	@Autowired
	private InscripcionRepository inscripcionRepository;

	@Override
	public void inscribirAlumno(Alumno alumno, Curso curso) {
		Inscripcion unaInscripcion = new Inscripcion();
		unaInscripcion.setAlumno(alumno);
		unaInscripcion.setCurso(curso);
		
		inscripcionRepository.save(unaInscripcion);
	}

	@Override
	public void deleteInscripcion(Alumno alumno, Curso curso) {

	}

}
