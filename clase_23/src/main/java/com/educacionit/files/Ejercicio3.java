package com.educacionit.files;

import java.util.Scanner;

import com.educacionit.files.clases.Alumno;
import com.educacionit.files.clases.ConsultarAlumno;

public class Ejercicio3 {

	private static String RUTA_ARCHIVO = "src/main/resources/alumnos.csv";
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int opcion;

		ConsultarAlumno alumnos = new ConsultarAlumno(RUTA_ARCHIVO);
	    do {
	    	System.out.println("1.- Consultar Legajo ");
	    	System.out.println("0.- Salir ");
	        opcion = scanner.nextInt();

	        if (opcion == 1) {
	        	System.out.println("Ingrese el Legajo a Consultar: ");
	            Integer legajo = scanner.nextInt();
	            try {
	            	Alumno unAlumno = alumnos.consultar(legajo);
		            System.out.println("El alumno con legajo: " + legajo +  " es: " + unAlumno);
	            } catch (Exception e) {
	            	System.out.println("El Alumno con legajo: "+ legajo + " no existe!");
	            }
	            
	        }
	    } while (opcion != 0);

	    scanner.close();
	}

}
