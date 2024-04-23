package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.Alumno;
import com.educacionit.dao.model.InscripcionAlumnoCurso;

public interface InscripcionAlumnoCursoDAO {
	
	public InscripcionAlumnoCurso buscarPorIdAlumnoCurso(Integer idAlumno, Integer idCurso);
	public List<InscripcionAlumnoCurso> buscarPorAlumno(Integer id);

	public void alta(Alumno alumno, Integer idCurso);
	public void baja(Integer idAlumno, Integer idCurso);
	public void modificacion(Alumno alumno, Integer idCursoActual, Integer idCursoNuevo);

}
