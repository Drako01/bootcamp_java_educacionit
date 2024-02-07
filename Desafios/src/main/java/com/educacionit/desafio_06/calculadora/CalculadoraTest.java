package com.educacionit.desafio_06.calculadora;

import java.util.Scanner;
import java.util.Locale;

public class CalculadoraTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		double numA, numB;
		char operacion;

		System.out.println("Ingrese un número a: ");
		numA = scanner.nextDouble();
		System.out.println("Ingrese un número b: ");
		numB = scanner.nextDouble();
		scanner.nextLine();

		while (true) {
			System.out.println("Ingrese la operación que desea realizar [+, -, *, /, %]: ");
			operacion = scanner.nextLine().charAt(0);

			switch (operacion) {
			case '+':
				System.out.println("La suma de " + numA + " y " + numB + " es: " + Calculadora.sumar(numA, numB));
				scanner.close();
				return;
			case '-':
				System.out.println("La resta de " + numA + " y " + numB + " es: " + Calculadora.restar(numA, numB));
				scanner.close();
				return;
			case '*':
				System.out.println(
						"La multiplicación de " + numA + " y " + numB + " es: " + Calculadora.multiplicar(numA, numB));
				scanner.close();
				return;
			case '/':
				if (numB == 0) {
					System.out.println("No se puede dividir por cero.");
					scanner.close();
					return;
				}
				try {
					System.out.println(
							"La división de " + numA + " entre " + numB + " es: " + Calculadora.dividir(numA, numB));
					scanner.close();
					return;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
				break;
			case '%':
				if (numB == 0) {
					System.out.println("No se puede calcular el resto de la división por cero.");
					scanner.close();
					return;
				}
				System.out.println("El resto de la división de " + numA + " entre " + numB + " es: "
						+ Calculadora.calcularResto(numA, numB));
				scanner.close();
				return;
			
			}
		}
	}
}
