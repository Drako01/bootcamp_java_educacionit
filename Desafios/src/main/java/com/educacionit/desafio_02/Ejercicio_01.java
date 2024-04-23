package com.educacionit.desafio_02;

import java.util.Scanner;

public class Ejercicio_01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingresa el número de horas: ");
		int horasTotales = scanner.nextInt();

		int semanas = horasTotales / 168;
		int dias = (horasTotales % 168) / 24;
		int horas = horasTotales % 24;

		System.out.println("Cantidad de horas Totales: " + horasTotales);
		System.out.println("Equivalente en semanas, días y horas:");
		System.out.println("Semanas: " + semanas);
		System.out.println("Días: " + dias);
		System.out.println("Horas: " + horas);

		scanner.close();
	}

}
