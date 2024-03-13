package com.educacionit;

import java.util.Scanner;

public class Ejercicio_01_For {

	public static void main(String[] args) {
		int exponente = 0;
		double base = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Ingrese la Base: ");
			base = scanner.nextDouble();
			if (base == 0) {
				continue;
			}
			System.out.println("Ingrese la Base: ");
			exponente = scanner.nextInt();
			if (exponente == 0) {
				break;
			}
			double resultado = 1;
			for (int contador = 0; contador < exponente; contador++) {
				resultado = resultado * base;
			}
			System.out.println("El resultado de " + base + " elevado a " + exponente + " es igual a: " + resultado);
		} while (base != 0 && exponente != 0);
		System.out.println("Fin del Ciclo!");
		scanner.close();
	}

}


