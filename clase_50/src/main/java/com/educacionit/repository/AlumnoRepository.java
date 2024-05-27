package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	

}
