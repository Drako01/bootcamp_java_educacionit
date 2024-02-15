package com.educacionit.files.clases;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AltaAlumno {

	@SuppressWarnings("unused")
	private String nombreArchivo;

	private FileWriter writer;

	public AltaAlumno(String nombreArchivo) throws IOException{
		super();
		this.nombreArchivo = nombreArchivo;
		writer = new FileWriter(nombreArchivo);
	}

	public void agregarAlumno() {
		
	    @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

	    System.out.println("Ingrese Legajo: ");
	    Integer legajo = scanner.nextInt();

	    System.out.println("Ingrese Nombre: ");
	    String nombre = scanner.next();

	    System.out.println("Ingrese Apellido: ");
	    String apellido = scanner.next();

	    scanner.nextLine();

	    System.out.println("Ingrese Edad: ");
	    Integer edad = scanner.nextInt();
	    
	    guardaAlumno(legajo, nombre, apellido, edad);
	}



	private void guardaAlumno(Integer legajo, String nombre, String apellido, Integer edad) {
		try {

			String registro = legajo + "," + nombre + "," + apellido + "," + edad + "\n";
			writer.write(registro);
			writer.flush();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() throws IOException{
		writer.close();
	}
}
