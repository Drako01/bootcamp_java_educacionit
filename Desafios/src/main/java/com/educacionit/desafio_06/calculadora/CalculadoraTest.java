package com.educacionit.desafio_06.calculadora;

import java.util.Scanner;
import java.util.Locale;

public class CalculadoraTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		double numA, numB;
		char operacion;

		System.out.println("Ingrese un número:");
		numA = scanner.nextDouble();
		System.out.println("Ingrese otro número:");
		numB = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Ingrese la operación que desea realizar [+, -, *, /, %]:");
		operacion = scanner.nextLine().charAt(0);

		Calculadora calculadora = new Calculadora(numA, numB, operacion);
		calculadora.setA(numA);
		calculadora.setB(numB);
		calculadora.setOperador(operacion);

		switch (operacion) {
		case '+':
			System.out.println("La suma de " + calculadora.getA() + " y " + calculadora.getB() + " es: "
					+ calculadora.sumar(numA, numB));
			break;
		case '-':
			System.out.println("La resta de " + calculadora.getA() + " y " + calculadora.getB() + " es: "
					+ calculadora.restar(numA, numB));
			break;
		case '*':
			System.out.println("La multiplicación de " + calculadora.getA() + " y " + calculadora.getB() + " es: "
					+ calculadora.multiplicar(numA, numB));
			break;
		case '/':
			try {
				System.out.println("La división de " + calculadora.getA() + " entre " + calculadora.getB() + " es: "
						+ calculadora.dividir(numA, numB));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		case '%':
			try {
				System.out.println("El resto de la división de " + calculadora.getA() + " entre " + calculadora.getB()
						+ " es: " + calculadora.calcularResto(numA, numB));
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.out.println("Operación no válida.");
		}
		scanner.close();
	}
}
