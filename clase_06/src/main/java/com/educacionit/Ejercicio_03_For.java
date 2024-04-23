package com.educacionit;

import java.util.Scanner;

public class Ejercicio_03_For {

	public static void main(String[] args) {
		System.out.println("Ingrese un Texto: ");
		Scanner scanner = new Scanner(System.in);
		String cadena = scanner.next();
		char[] toUpperCase = new char[cadena.length()];
		for (int i = 0; i < cadena.length(); i++) {
			char unCaracter = cadena.charAt(i);
			if (unCaracter >= 'a' && unCaracter <= 'z') {
				toUpperCase[i] = (char) (unCaracter - 32);
			} else {
				toUpperCase[i] = unCaracter;
			}

		}
		System.out.println(new String(toUpperCase));
		scanner.close();
	}

}

/*
 * Para el caso de toLowerCase se pone un +32 y en el if se ponen las Mayusculas
*/
