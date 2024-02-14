package com.educacionit.files;

import java.util.Scanner;

import com.educacionit.files.clases.AltaAlumno;

public class Ejercicio2 {

	private static String NOMBRE_ARCHIVO = "src/main/resources/alumnos.txt";

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		AltaAlumno alumno = new AltaAlumno(NOMBRE_ARCHIVO);

		int opcion;

		do {
			System.out.println("1.- Ingresar un Alumno ");
			System.out.println("2.- Salir ");
			opcion = scanner.nextInt();

			if (opcion == 1) {
				alumno.agregarAlumno();
			}
		} while (opcion == 1);

	}

}
