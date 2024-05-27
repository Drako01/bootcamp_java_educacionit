package com.educacionit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Alumno;
import com.educacionit.entity.Curso;
import com.educacionit.entity.Inscripcion;
import com.educacionit.repository.InscripcionRespository;
import com.educacionit.service.InscripcionService;

@Service
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	private InscripcionRespository inscripcionRespository;
	
	@Override
	public void inscribirAlumno(Alumno alumno, Curso curso) {
		
		Inscripcion unaInscripcion = new Inscripcion();
		
		unaInscripcion.setAlumno(alumno);
		unaInscripcion.setCurso(curso);
	
		inscripcionRespository.save(unaInscripcion);

	}
	
	@Override
	public void eliminarInscripcion(Alumno alumno, Curso curso) throws Exception {
		
		Inscripcion unaInscription = inscripcionRespository.findByAlumnoAndCurso(alumno, curso);
		
		if (unaInscription != null) {
			inscripcionRespository.delete(unaInscription);
		} else {
			throw new Exception("No se pudo encontrar el alumno: " + alumno + " con curso: "  + curso);
		}
	}
	
	
	
	/*@Override
	public void inscribirAlumno(Long idAlumno, Long idCurso) {
		
		Alumno unAlumno = new Alumno();
		unAlumno.setId(idAlumno);
		
		Curso unCurso = new Curso();
		unCurso.setId(idCurso);
		
		Inscripcion unaInscripcion = new Inscripcion(unAlumno, unCurso);	
		
		inscripcionRespository.save(unaInscripcion);		
	}*/



}
