package com.educacionit.dao;

import java.util.List;

import com.educacionit.model.Alumno;

public interface AlumnoDAO {

	public List<Alumno> getAll();

	public Alumno save(Alumno alumno);

}
