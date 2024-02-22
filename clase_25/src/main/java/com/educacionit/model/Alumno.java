package com.educacionit.model;

public class Alumno {

	private String nombre;
	private Integer legajo;
	private Integer edad;
	private static int contadorLegajo = 1000;

	public Alumno() {
		super();
		this.legajo = ++Alumno.contadorLegajo;
	}

	public Alumno(String nombre, Integer edad) {
		this();
		this.nombre = nombre;
		this.edad = edad;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", legajo=" + legajo + ", edad=" + edad + "]";
	}

}
