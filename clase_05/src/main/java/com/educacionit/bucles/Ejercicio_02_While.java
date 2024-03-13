package com.educacionit.bucles;

import java.util.Scanner;

public class Ejercicio_02_While {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese la cantidad de numeros a leer por teclado: ");
		int cantidadDeNumerosAIngresar = scanner.nextInt();
		int contadorDeNumerosIngresados = 0;
		int contadorMenoresQueCero = 0;
		int contadorIgualesACero = 0;
		int contadorMayoresQueCero = 0;

		while (contadorDeNumerosIngresados < cantidadDeNumerosAIngresar) {
			System.out.println("Ingreso: " + (contadorDeNumerosIngresados+1) + " - Ingrese un Numero: ");
			int numeroIngresado = scanner.nextInt();
			if (numeroIngresado > 0) {
				contadorMayoresQueCero++;
			} else if (numeroIngresado < 0) {
				contadorMenoresQueCero++;
			} else {
				contadorIgualesACero++;
			}
			contadorDeNumerosIngresados++;
		}

		System.out.println("Cantidad de Numeros menores que Cero: " + contadorMenoresQueCero);
		System.out.println("Cantidad de Numeros iguales a Cero: " + contadorIgualesACero);
		System.out.println("Cantidad de Numeros mayores que Cero: " + contadorMayoresQueCero);
		scanner.close();
	}

	
}
