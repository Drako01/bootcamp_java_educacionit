package com.educacionit;

import java.util.Scanner;

public class ejercicioScanner01 {

	public static void main(String[] args) {
		int array[] = new int[3];

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un valor Entero: ");
		array[0] = scanner.nextInt();
		
		System.out.println("Ingrese otro valor Entero: ");
		array[1] = scanner.nextInt();
		
		System.out.println("Ingrese otro valor Entero más: ");
		array[2] = scanner.nextInt();
		
		// System.out.println("Valor: " + array[0]); //Hace lo mismo que la sentencia de abajo
		System.out.printf("Valor de la posicion 1: [%d]\n", array[0]);
		System.out.printf("Valor de la posicion 2: [%d]\n", array[1]);
		System.out.printf("Valor de la posicion 3: [%d]\n", array[2]);
		scanner.close();
	}

}

