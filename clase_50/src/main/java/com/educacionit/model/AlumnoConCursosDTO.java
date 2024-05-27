package com.educacionit.model;

import java.util.List;

public class AlumnoConCursosDTO {
	
	private String nombre;
	private Integer legajo;
	private List<String> cursos;
	public AlumnoConCursosDTO(String nombre, Integer legajo) {
		super();
		this.nombre = nombre;
		this.legajo = legajo;
	}
	public AlumnoConCursosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getLegajo() {
		return legajo;
	}
	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}
	public List<String> getCursos() {
		return cursos;
	}
	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}
	@Override
	public String toString() {
		return "AlumnoConCursosDTO [nombre=" + nombre + ", legajo=" + legajo + ", cursos=" + cursos + "]";
	}
	
	
 

}
