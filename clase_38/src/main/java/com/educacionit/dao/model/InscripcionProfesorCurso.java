package com.educacionit.dao.model;

import java.util.Date;

public class InscripcionProfesorCurso {
	
	private Profesor profesor;
	private Curso curso;
	private Date fechaAltaInscripcion;
	public InscripcionProfesorCurso(Profesor profesor, Curso curso, Date fechaAltaInscripcion) {
		super();
		this.profesor = profesor;
		this.curso = curso;
		this.fechaAltaInscripcion = fechaAltaInscripcion;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
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
