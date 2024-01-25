package com.educacionit.string;

import java.util.Scanner;

public class ejercicioString03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese Primer Cadena: ");
		String primerCadena = scanner.nextLine();
		System.out.println("Ingrese Segunda Cadena: ");
		String segundaCadena = scanner.nextLine();

		String myStringEmpty = "";
		System.out.println("Longitud de la Primer Cadena: " + primerCadena.length());
		System.out.println("Longitud de la Segunda Cadena: " + segundaCadena.length());
		System.out.println("Longitud de myStringEmpty es: " + myStringEmpty.length());

		if (primerCadena.isEmpty() || primerCadena.isBlank()) {
			System.out.println("La Primer Cadena tiene Longitud 0 o esta Todo en Blanco");
		}
		if (segundaCadena.isEmpty() || segundaCadena.isBlank()) {
			System.out.println("La Segunda Cadena tiene Longitud 0 o esta Todo en Blanco");
		}
		if (primerCadena.equalsIgnoreCase(segundaCadena)) {
			System.out.println("Las Cadenas son Iguales");
		} else {
			System.out.println("Las Cadenas son Distintas");
		}
		scanner.close();
	}

}
