package com.educacionit.desafio_08.ejercicio_02.models;

public class Provincia {

	private Integer id;
	private String descripcion;
	private Integer paisId;

	public Provincia() {
		super();
	}

	public Provincia(Integer id, String descripcion, Integer paisId) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.paisId = paisId;
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

	public Integer getPaisId() {
		return paisId;
	}

	public void setPaisId(Integer paisId) {
		this.paisId = paisId;
	}

	@Override
	public String toString() {
		return "Provincia [id=" + id + ", descripcion=" + descripcion + ", paisId=" + paisId + "]";
	}
}
