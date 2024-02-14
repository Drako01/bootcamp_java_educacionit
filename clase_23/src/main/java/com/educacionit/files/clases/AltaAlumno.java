package com.educacionit.files.clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AltaAlumno {
	
	private String nombreArchivo;
	

	public AltaAlumno(String nombreArchivo) {
		super();
		this.nombreArchivo = nombreArchivo;
	}

	public void agregarAlumno() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese Legajo: ");
		Integer legajo = scanner.nextInt();

		System.out.println("Ingrese Nombre: ");
		String nombre = scanner.next();

		System.out.println("Ingrese Apellido: ");
		String apellido = scanner.next();

		System.out.println("Ingrese Edad: ");
		Integer edad = scanner.nextInt();

	}

	private void guardaAlumno(Integer legajo, String nombre, String apellido, Integer edad) {
		try {
			FileWriter writer = new FileWriter(nombreArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
