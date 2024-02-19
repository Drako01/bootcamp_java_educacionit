package com.educacionit.desafio_06.calculadora;

public class Calculadora {
	private double a;
	private double b;
	private char operador;

	public Calculadora(double a, double b, char operador) {
		this.a = a;
		this.b = b;
		this.operador = operador;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public char getOperador() {
		return operador;
	}

	public void setOperador(char operador) {
		this.operador = operador;
	}

	public double sumar(double numA, double numB) {
		this.a = numA;
		this.b = numB;
		return a + b;
	}

	public double restar(double numA, double numB) {
		this.a = numA;
		this.b = numB;
		return a - b;
	}

	public double multiplicar(double numA, double numB) {
		this.a = numA;
		this.b = numB;
		return a * b;
	}

	public double dividir(double numA, double numB) {
		if (b != 0) {
			this.a = numA;
			this.b = numB;
			return a / b;
		} else {
			throw new IllegalArgumentException("No se puede dividir por cero.");
		}
	}

	public double calcularResto(double numA, double numB) {
		if (b != 0) {
			this.a = numA;
			this.b = numB;
			return a % b;
		} else {
			throw new IllegalArgumentException("No se puede calcular el resto de la división por cero.");
		}
	}
}
