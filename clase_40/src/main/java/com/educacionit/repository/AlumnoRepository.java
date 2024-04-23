package com.educacionit.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educacionit.model.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository {
	
	public List<Alumno> getAll();
	
	public Alumno save(Alumno alumno);


}
