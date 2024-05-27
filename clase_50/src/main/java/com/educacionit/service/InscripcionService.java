package com.educacionit.service;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;

public interface InscripcionService {
	
	public void inscribirAlumno(Alumno alumno, Curso curso);
	//public void inscribirAlumno(Long idAlumno, Long idCurso);
	
	public void eliminarInscripcion(Alumno alumno, Curso curso) throws Exception;

}
