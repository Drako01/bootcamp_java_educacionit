package com.educacionit.service;

import java.util.List;

import com.educacionit.entity.Alumno;

public interface AlumnoService {

	public List<Alumno> getAllAlumnos();

	public Alumno getById(Long id) throws Exception;

	public Alumno saveAlumno(Alumno unAlumno);

	public void deleteAlumno(Long id);
}
