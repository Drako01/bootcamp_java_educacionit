package com.educacionit.casteo;

import java.util.Scanner;

public class Ejercicio02_Casteo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un Valor con Decimales: ");
		double unDouble = scanner.nextDouble();
		System.out.printf("El Valor Ingresado es: %.2f\n", unDouble);
		
		int parteEntera = (int)unDouble;
		double resultado = unDouble - parteEntera;
		
		if(resultado != 0) {
			System.out.println("El Valor " + unDouble + " tiene Decimales");
		} else {
			System.out.println("El Valor "  + unDouble + "  No tiene Decimales");
		}
		scanner.close();
	}

}
