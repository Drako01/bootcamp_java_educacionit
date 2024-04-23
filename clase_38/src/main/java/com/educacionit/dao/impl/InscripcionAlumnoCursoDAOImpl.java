package com.educacionit.dao.impl;

import java.util.List;

import com.educacionit.dao.InscripcionAlumnoCursoDAO;
import com.educacionit.dao.model.Alumno;
import com.educacionit.dao.model.Curso;
import com.educacionit.dao.model.InscripcionAlumnoCurso;

public class InscripcionAlumnoCursoDAOImpl implements InscripcionAlumnoCursoDAO {

	public InscripcionAlumnoCursoDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InscripcionAlumnoCurso buscarPorIdAlumnoCurso(Integer idAlumno, Integer idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InscripcionAlumnoCurso> buscarPorAlumno(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(Alumno alumno, Integer idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void baja(Integer idAlumno, Integer idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificacion(Alumno alumno, Integer idCursoActual, Integer idCursoNuevo) {
		// TODO Auto-generated method stub

	}

}
