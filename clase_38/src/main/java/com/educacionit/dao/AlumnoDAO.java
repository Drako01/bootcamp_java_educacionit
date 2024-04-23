package com.educacionit.dao;

import java.util.List;

import com.educacionit.dao.model.Alumno;

public interface AlumnoDAO {
	
	public Alumno buscarPorId(Integer id);
	public List<Alumno> buscarTodos();

	public Integer alta(Alumno alumno);
	public void baja(Integer id);
	public void modificacion(Alumno alumno);

}
