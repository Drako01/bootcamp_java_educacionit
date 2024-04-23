package com.educacionit.desafio_07.desafiojava1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.educacionit.desafio_07.desafiojava1.clases.Alumno;
import com.educacionit.desafio_07.desafiojava1.clases.Resultados;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int cantidadAlumnos = 0;
		boolean entradaValida = false;

		while (!entradaValida) {
			try {
				System.out.print("Ingrese la cantidad de alumnos a procesar: ");
				cantidadAlumnos = scanner.nextInt();
				scanner.nextLine();
				entradaValida = true;
			} catch (InputMismatchException ex) {
				System.out.println("Error: Ingrese un número entero válido.");
				scanner.nextLine();
			}
		}

		Alumno[] alumnos = new Alumno[cantidadAlumnos];

		for (int i = 0; i < cantidadAlumnos; i++) {
			System.out.println("Ingrese los datos para el alumno " + (i + 1) + ":");
			System.out.print("Nombre: ");
			String nombre = scanner.nextLine();
			System.out.print("Apellido: ");
			String apellido = scanner.nextLine();
			int cantidadExamenes = 0;
			entradaValida = false;

			while (!entradaValida) {
				try {
					System.out.print("Cantidad de exámenes: ");
					cantidadExamenes = scanner.nextInt();
					scanner.nextLine();
					entradaValida = true;
				} catch (InputMismatchException ex) {
					System.out.println("Error: Ingrese un número entero válido.");
					scanner.nextLine();
				}
			}
			Alumno alumno = new Alumno(nombre, apellido, cantidadExamenes);

			for (int j = 1; j <= cantidadExamenes; j++) {
				double nota = 0;
				entradaValida = false;

				while (!entradaValida) {
					try {
						System.out.print("Nota del Exámen " + j + ": ");
						nota = scanner.nextDouble();
						scanner.nextLine();
						if (nota < 0 || nota > 10) {
							System.out.println("Error: La nota debe estar entre 0 y 10.");
						} else {
							entradaValida = true;
						}
					} catch (InputMismatchException ex) {
						System.out.println("Error: Ingrese un número válido para la nota.");
						scanner.nextLine();
					}
				}

				alumno.getNotas()[j - 1] = nota;
			}

			alumnos[i] = alumno;
		}

		List<Alumno> mejoresAlumnos = Resultados.encontrarCalificacionMasAlta(alumnos);
		System.out.println("Alumno/s con la calificación más alta:");
		for (Alumno alumno : mejoresAlumnos) {
			System.out.println(alumno);
		}

		List<Alumno> peoresAlumnos = Resultados.encontrarCalificacionMasBaja(alumnos);
		System.out.println("Alumno/s con la calificación más baja:");
		for (Alumno alumno : peoresAlumnos) {
			System.out.println(alumno);
		}

		List<Alumno> promocionAlumnos = Resultados.encontrarAlumnosPromocionan(alumnos);
		System.out.println("Alumnos que promocionan:");
		if (promocionAlumnos.isEmpty()) {
			System.out.println("No hay datos para mostrar");
		} else {
			for (Alumno alumno : promocionAlumnos) {
				System.out.println(alumno);
			}
		}

		List<Alumno> recursarAlumnos = Resultados.encontrarAlumnosRecursar(alumnos);
		System.out.println("Alumnos que deben recursar la materia:");
		if (recursarAlumnos.isEmpty()) {
			System.out.println("No hay datos para mostrar");
		} else {
			for (Alumno alumno : recursarAlumnos) {
				System.out.println(alumno);
			}
		}

		scanner.close();
	}
}
