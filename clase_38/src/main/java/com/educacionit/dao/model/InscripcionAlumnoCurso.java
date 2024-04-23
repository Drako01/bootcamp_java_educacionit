package com.educacionit.dao.model;

import java.util.Date;

public class InscripcionAlumnoCurso {
	
	private Alumno alumno;
	private Curso curso;
	private Date fechaAltaInscripcion;
	public InscripcionAlumnoCurso(Alumno alumno, Curso curso, Date fechaAltaInscripcion) {
		super();
		this.alumno = alumno;
		this.curso = curso;
		this.fechaAltaInscripcion = fechaAltaInscripcion;
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
	public Date getFechaAltaInscripcion() {
		return fechaAltaInscripcion;
	}
	public void setFechaAltaInscripcion(Date fechaAltaInscripcion) {
		this.fechaAltaInscripcion = fechaAltaInscripcion;
	}
	
	

}
