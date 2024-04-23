package com.educacionit.polimorfismo;

public class EmpleadoNormal extends Empleado {

	private String categoria;

	public EmpleadoNormal(String nombre, Double salario, String categoria) {
		super(nombre, salario);
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "EmpleadoNormal [categoria=" + categoria + "]";
	}
	

	
}
