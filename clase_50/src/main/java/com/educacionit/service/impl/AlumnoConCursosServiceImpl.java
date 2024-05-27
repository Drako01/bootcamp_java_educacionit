package com.educacionit.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.AlumnoConCursos;
import com.educacionit.entity.Curso;
import com.educacionit.model.AlumnoConCursosDTO;
import com.educacionit.repository.AlumnoConCursosRepository;
import com.educacionit.service.AlumnoConCursosService;

import jakarta.transaction.Transactional;

@Service
public class AlumnoConCursosServiceImpl implements AlumnoConCursosService {

	@Autowired
	private AlumnoConCursosRepository alumnoConCursosRepository;
	
	@Override
	@Transactional
	public AlumnoConCursosDTO getAlumnoConCursosById(Long id) throws Exception {
		
		Optional<AlumnoConCursos> unAlumnoConCursos = alumnoConCursosRepository.findById(id);
		AlumnoConCursos alumnoConCursosARetornar = null;
		
		if (unAlumnoConCursos.isPresent()) {
			alumnoConCursosARetornar = unAlumnoConCursos.get();
		} else {
			throw new Exception("No se pudo encontrar el alumno con Id: " + id);
		}
		
		AlumnoConCursosDTO alumnoConCursosDTO = construirAlumnoConCursosDTO(alumnoConCursosARetornar);
		return alumnoConCursosDTO;
	}
	
	
	
	private AlumnoConCursosDTO construirAlumnoConCursosDTO( AlumnoConCursos alumnoConCursosARetornar) {
		
		AlumnoConCursosDTO alumnoConCursosDTO = new AlumnoConCursosDTO();
		
		alumnoConCursosDTO.setNombre(alumnoConCursosARetornar.getNombre());
		alumnoConCursosDTO.setLegajo(alumnoConCursosARetornar.getLegajo());
		
		List<String> cursosString = new ArrayList<>();
		
		List<Curso> cursosEntidad = alumnoConCursosARetornar.getCursos();
		for (Curso curso : cursosEntidad) {
			cursosString.add(curso.getDescripcion());
		}
		
		alumnoConCursosDTO.setCursos(cursosString);
		
		return alumnoConCursosDTO;
		
	}

}
