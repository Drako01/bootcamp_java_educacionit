package com.educacionit.dao.impl;

import java.util.List;

import com.educacionit.dao.InscripcionProfesorCursoDAO;
import com.educacionit.dao.model.Curso;
import com.educacionit.dao.model.InscripcionProfesorCurso;
import com.educacionit.dao.model.Profesor;

public class InscripcionProfesorCursoDAOImpl implements InscripcionProfesorCursoDAO {

	public InscripcionProfesorCursoDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InscripcionProfesorCurso buscarPorIdProfesorCurso(Integer idAlumno, Integer idCurso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InscripcionProfesorCurso> buscarPorProfesor(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void baja(Integer idProfesor, Integer idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificacion(Profesor profesor, Integer idCursoActual, Integer idCursoNuevo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alta(Integer idProfesor, Integer idCurso) {
		// TODO Auto-generated method stub
		
	}

}
