package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
