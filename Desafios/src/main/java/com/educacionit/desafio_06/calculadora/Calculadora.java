package com.educacionit.desafio_06.calculadora;

public class Calculadora {

	public static double sumar(double num1, double num2) {
		return num1 + num2;
	}

	public static double restar(double num1, double num2) {
		return num1 - num2;
	}

	public static double multiplicar(double num1, double num2) {
		return num1 * num2;
	}

	public static double dividir(double num1, double num2) {
		if (num2 != 0) {
			return num1 / num2;
		} else {
			//Uso IllegalArgumentException que extiende de RuntimeException para el manejo de Excepciones
			throw new IllegalArgumentException("No se puede dividir por cero.");
		}
	}

	public static double calcularResto(double num1, double num2) {
		if (num2 != 0) {
			return num1 % num2;
		} else {
			throw new IllegalArgumentException("No se puede dividir p cero.");
		}
	}
}
