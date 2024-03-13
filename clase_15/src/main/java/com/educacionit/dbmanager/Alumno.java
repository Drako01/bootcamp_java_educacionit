package com.educacionit.dbmanager;

public class Alumno {

	private Integer legajo;
	private String nombre;
	private Integer edad;
	private String especialidad;

	public Alumno(Integer legajo, String nombre) {
		this.legajo = legajo;
		this.nombre = nombre;
	}

	public Alumno(Integer legajo, String nombre, Integer edad) {
		this(legajo, nombre);
		this.edad = edad;
	}

	public Alumno(Integer legajo, String nombre, Integer edad, String especialidad) {
		this(legajo, nombre, edad);
		this.especialidad = especialidad;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	@Override
	public String toString() {
		return "Alumno [legajo=" + legajo + ", nombre=" + nombre + ", edad=" + edad + ", especialidad=" + especialidad
				+ "]";
	}

}
