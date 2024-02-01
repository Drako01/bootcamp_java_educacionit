package com.educacionit.generics;

public class Alumno <T, S extends Number>{

	private T legajo;
	private S promedio;
	
	/*
	public Alumno(T legajo, S promedio) {
		super();
		this.legajo = legajo;
		this.promedio = promedio;
	}*/
	
	public T getLegajo() {
		return legajo;
	}
	public void setLegajo(T legajo) {
		this.legajo = legajo;
	}
	public S getPromedio() {
		return promedio;
	}
	public void setPromedio(S promedio) {
		this.promedio = promedio;
	}
	
	
	
	
}
