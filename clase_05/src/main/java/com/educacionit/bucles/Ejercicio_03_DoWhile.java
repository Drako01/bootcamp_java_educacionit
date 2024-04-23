package com.educacionit.bucles;

import java.util.Scanner;

public class Ejercicio_03_DoWhile {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int valor;

		do {
			System.out.println("Ingrese un Valor entre 1 y 999 (con 0 Finaliza): ");
			valor = scanner.nextInt();
			if (valor < 0 | valor > 999) {
				System.out.println("Valor Fuera de Rango");
				continue;
			}
			
			if (valor >= 100) {
				System.out.println("El Valor Tiene 3 Cifras");
			} else if (valor >= 10) {
				System.out.println("El Valor Tiene 2 Cifras");
			} else if (valor > 0) {
				System.out.println("El Valor Tiene 1 Cifra");
			}
			
		} while (valor != 0);
		
		System.out.println("Fin");
		scanner.close();
	}

}
