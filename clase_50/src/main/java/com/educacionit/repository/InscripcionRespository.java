package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;
import com.educacionit.entity.Inscripcion;

public interface InscripcionRespository extends JpaRepository<Inscripcion, Long> {
	
	Inscripcion findByAlumnoAndCurso(Alumno alumno, Curso curso);
	

}
