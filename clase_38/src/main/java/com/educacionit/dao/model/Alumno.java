package com.educacionit.dao.model;

import java.util.Date;

public class Alumno {
	private Integer id;
	private String nombre;
	private String apellido;
	private int edad;
	private String direccion;
	private Date fechaNacimiento;
	private Especialidad especialidad;

	public Alumno(Integer id, String nombre, String apellido, int edad, String direccion, Date fechaNacimiento,
			Especialidad especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.especialidad = especialidad;
	}
	
	public Alumno(String nombre, String apellido, int edad, String direccion, Date fechaNacimiento,
			Especialidad especialidad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.especialidad = especialidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

}
