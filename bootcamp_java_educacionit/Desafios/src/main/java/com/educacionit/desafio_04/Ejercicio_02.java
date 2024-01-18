package com.educacionit.desafio_04;

import java.util.Scanner;

class PronosticoTiempo {
	private double temperatura;
	private String estadoTiempo;

	public PronosticoTiempo(double temperatura, String estadoTiempo) {
		this.temperatura = temperatura;
		this.estadoTiempo = estadoTiempo;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public String getEstadoTiempo() {
		return estadoTiempo;
	}
}

class SugerenciasTiempo {

	public static void obtenerSugerencias(PronosticoTiempo pronostico) {
		double temperatura = pronostico.getTemperatura();
		String tiempo = pronostico.getEstadoTiempo();
		/*
		 * A diferencia del Ejercicio 01, aca utilice el método equalsIgnoreCase para
		 * que al ingresar un texto por teclado, ignore si esta en mayusculas o
		 * minusculas Ejemplo: Si ingreso Soleado o SOLEADO o soleado, para este
		 * Programa va a ser lo mismo.
		 */
		if (temperatura > 25 && tiempo.equalsIgnoreCase("Soleado")) {
			System.out.println("Puedes caminar y tomar sol.");
		} else if (temperatura > 15 && temperatura <= 25 && tiempo.equalsIgnoreCase("Soleado")) {
			System.out.println("Puedes caminar.");
		} else if (temperatura <= 15 && tiempo.equalsIgnoreCase("Soleado")) {
			System.out.println("Puedes caminar con campera.");
		} else if (temperatura < 10 && tiempo.equalsIgnoreCase("Lluvia")) {
			System.out.println("Debes quedarte en casa o salir con paraguas y campera.");
		} else if (temperatura < 10 && tiempo.equalsIgnoreCase("Nieve")) {
			System.out.println("Puedes esquiar.");
		} else {
			System.out.println("No se proporcionaron sugerencias para el pronóstico dado.");
		}
	}
}

public class Ejercicio_02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese la temperatura actual: ");
		double temperatura = scanner.nextDouble();

		System.out.print("Ingrese el estado del tiempo (Soleado, Lluvia, Nieve): ");
		String tiempo = scanner.next();
		
		PronosticoTiempo pronostico = new PronosticoTiempo(temperatura, tiempo);
		
		SugerenciasTiempo.obtenerSugerencias(pronostico);
		
		scanner.close();
	}

}
