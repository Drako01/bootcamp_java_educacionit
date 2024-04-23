package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.InscripcionProfesorCurso;
import com.educacionit.dao.model.Profesor;

public interface InscripcionProfesorCursoDAO {
	
	public InscripcionProfesorCurso buscarPorIdProfesorCurso(Integer idAlumno, Integer idCurso);
	public List<InscripcionProfesorCurso> buscarPorProfesor(Integer id);

	public void alta(Integer idProfesor, Integer idCurso);
	public void baja(Integer idProfesor, Integer idCurso);
	public void modificacion(Profesor profesor, Integer idCursoActual, Integer idCursoNuevo);

}
