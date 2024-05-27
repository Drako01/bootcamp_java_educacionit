package com.educacionit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_alumno")
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public Inscripcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inscripcion(Alumno alumno, Curso curso) {
		super();
		this.alumno = alumno;
		this.curso = curso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Inscripcion [id=" + id + ", alumno=" + alumno + ", curso=" + curso + "]";
	}
	
	

}
