package com.educacionit.ejercicio01;

public class Triangulo implements Forma {

	Double lado1;
	Double lado2;
	Double lado3;

	public Triangulo(Double lado1, Double lado2, Double lado3) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado3 = lado3;
	}

	@Override
	public Double calcularArea() {
		double s = (lado1 + lado2 + lado3) / 2;
		return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
	}

	@Override
	public String toString() {
		return "Triangulo [lado1=" + lado1 + ", lado2=" + lado2 + ", lado3=" + lado3 + "]";
	}

	@Override
	public Double calcularPerimetro() {
		return lado1 + lado2 + lado3;
	}

}