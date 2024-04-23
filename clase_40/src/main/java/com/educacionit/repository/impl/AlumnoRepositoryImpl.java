package com.educacionit.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.educacionit.dao.AlumnoDAO;
import com.educacionit.dao.AlumnoDAOImpl;
import com.educacionit.model.Alumno;
import com.educacionit.repository.AlumnoRepository;

@Repository("alumnoRepository")
public class AlumnoRepositoryImpl implements AlumnoRepository {
	

	@Override
	public List<Alumno> getAll() {
		AlumnoDAO alumnoDao = new AlumnoDAOImpl();
		
		return alumnoDao.getAll();
	}

	@Override
	public Alumno save(Alumno alumno) {
		AlumnoDAO alumnoDao = new AlumnoDAOImpl();
		
		return alumnoDao.save(alumno);
	}

}
