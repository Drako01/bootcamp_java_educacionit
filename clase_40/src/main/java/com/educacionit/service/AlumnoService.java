package com.educacionit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.educacionit.model.Alumno;

@Service("alumnoService")
public interface AlumnoService {
	
	public List<Alumno> getAll();
	
	public Alumno save(Alumno alumno);

}
