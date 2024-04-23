package com.educacionit.desafio_08.ejercicio_01.models;

public class Pais {

	private Integer id;
	private String descripcion;

	public Pais() {
		super();
	}

	public Pais(Integer id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", descripcion=" + descripcion + "]";
	}

}
