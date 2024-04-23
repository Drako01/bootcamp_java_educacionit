package com.educacionit.dao;

import java.util.ArrayList;
import java.util.List;

import com.educacionit.model.Alumno;

public class AlumnoDAOImpl implements AlumnoDAO {
	
	private static List<Alumno>  alumnos = new ArrayList<>();

	public AlumnoDAOImpl() {
		super();
		alumnos.add(new Alumno(1234, "Nombre1234"));
		alumnos.add(new Alumno(5678, "Nombre5678"));

	}

	@Override
	public List<Alumno> getAll() {
		return alumnos;
	}

	@Override
	public Alumno save(Alumno alumno) {
		alumnos.add(alumno);
		return alumno;
	}

}
