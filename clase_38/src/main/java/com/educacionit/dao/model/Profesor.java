package com.educacionit.dao.model;

import java.util.Date;

public class Profesor {
	private Integer id;
	private String nombre;
	private String especialidad;
	private Date fechaNacimiento;

	public Profesor(Integer id, String nombre, String especialidad, Date fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Profesor(String nombre, String especialidad, Date fechaNacimiento) {
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
