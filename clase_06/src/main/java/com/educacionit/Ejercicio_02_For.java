package com.educacionit;

import java.util.Scanner;

public class Ejercicio_02_For {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese una Frase: ");
		String cadena = scanner.nextLine();
		String [] arrayString = cadena.split(" ");
		
		for(int i = 0; i < arrayString.length; i++) {
			System.out.println((i+1) + ".- "+  arrayString[i]);
		}
		scanner.close();
	}

}
