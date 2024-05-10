package com.educacionit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Alumno;
import com.educacionit.repository.AlumnoRepository;
import com.educacionit.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> getAllAlumnos() {		
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno getById(Long id) throws Exception{
		Optional<Alumno> unAlumno = alumnoRepository.findById(id);
		if(unAlumno.isPresent()) {
			return unAlumno.get();
		} else {
			throw new Exception("El Alumno con ID: " + id + " no Existe en la BD");
		}
	}

	@Override
	public Alumno saveAlumno(Alumno unAlumno) {		
		return alumnoRepository.save(unAlumno);
	}

	@Override
	public void deleteAlumno(Long id) {
		alumnoRepository.deleteById(id);		
	}

	
}
