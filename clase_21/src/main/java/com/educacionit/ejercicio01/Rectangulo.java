package com.educacionit.ejercicio01;

public class Rectangulo implements Forma {

	Double longitud;

	Double ancho;

	public Rectangulo(Double longitud, Double ancho) {
		super();
		this.longitud = longitud;
		this.ancho = ancho;
	}

	@Override
	public Double calcularArea() {
		return longitud * ancho;
	}

	@Override
	public Double calcularPerimetro() {
		return 2 * longitud + 2 * ancho;
	}

	@Override
	public String toString() {
		return "Rectangulo [longitud=" + longitud + ", ancho=" + ancho + "]";
	}

}