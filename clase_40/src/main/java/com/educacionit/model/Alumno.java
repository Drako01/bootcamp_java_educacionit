package com.educacionit.model;

public class Alumno {

	private Integer id;
	private Integer legajo;
	private String nombre;

	public Alumno(Integer legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public Alumno() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + "]";
	}

}
