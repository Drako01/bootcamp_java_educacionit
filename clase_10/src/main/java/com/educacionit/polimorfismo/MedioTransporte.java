package com.educacionit.polimorfismo;

public abstract class MedioTransporte {

	private String nombre;
	public MedioTransporte() {
		super();
	}
	public abstract void despazarse();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
