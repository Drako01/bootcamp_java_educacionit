package com.educacionit.dao.service;

import java.util.List;

import com.educacionit.dao.model.Alumno;
import com.educacionit.dao.model.Curso;
import com.educacionit.dao.model.Especialidad;
import com.educacionit.dao.model.InscripcionAlumnoCurso;
import com.educacionit.dao.model.Profesor;

public interface AlumnoProfesoreCursoService {
	
	// 3.A.- Permitir inscribir a un curso a un alumno nuevo.
	public void inscribirAlumnoNuevoACurso(Alumno alumnoNuevo, Integer idCurso);
	
	// 3.B.- Permitir inscribir a un nuevo profesor en un nuevo curso
	public void inscribirNuevoProfesorANuevoCurso(Profesor nuevoProfesor, Curso nuevoCurso);
	
	// 3.C -
	public void modificarAlumnoConNuevaEspecialidad(Alumno alumno, Especialidad especialidad);
	
	// 3.D - Obtener todos los cursos en los que está inscrito un alumno específico.
	public List<InscripcionAlumnoCurso> obtenerCursosDeAlumno(Integer idAlumno);
	

}
