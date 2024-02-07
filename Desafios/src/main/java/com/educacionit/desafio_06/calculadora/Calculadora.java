package com.educacionit.desafio_06.calculadora;

public class Calculadora {

	public static <N extends Number> double sumar(N numA, N numB) {
		return numA.doubleValue() + numB.doubleValue();
	}

	public static <N extends Number> double restar(N numA, N numB) {
		return numA.doubleValue() - numB.doubleValue();
	}

	public static <N extends Number> double multiplicar(N numA, N numB) {
		return numA.doubleValue() * numB.doubleValue();
	}

	public static <N extends Number> double dividir(N numA, N numB) {
		double n1 = numA.doubleValue();
		double n2 = numB.doubleValue();
		if (n2 != 0) {
			return n1 / n2;
		} else {
			throw new IllegalArgumentException("No se puede dividir por cero.");
		}
	}

	public static <N extends Number> double calcularResto(N numA, N numB) {
		double n1 = numA.doubleValue();
		double n2 = numB.doubleValue();
		if (n2 != 0) {
			return n1 % n2;
		} else {
			throw new IllegalArgumentException("No se puede calcular el resto de la división por cero.");
		}
	}
}
