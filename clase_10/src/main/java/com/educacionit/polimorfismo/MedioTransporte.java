package com.educacionit.polimorfismo;

public abstract class MedioTransporte implements IDesplazamiento{

	private String nombre;
	public MedioTransporte() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
