package com.educacionit.polimorfismo;

public class Gerente extends Empleado {

	
	private String departamento;

	public Gerente(String nombre, Double salario, String departamento) {
		super(nombre, salario);
		this.departamento = departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Gerente [departamento=" + departamento + "]";
	}
	
	

}
