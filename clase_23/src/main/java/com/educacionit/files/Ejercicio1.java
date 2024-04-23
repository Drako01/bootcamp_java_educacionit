package com.educacionit.files;

import java.io.File;

public class Ejercicio1 {

	private static String RUTA_BASE = "src/main/resources";

	public static void main(String[] args) {
		File file = new File(RUTA_BASE);

		String[] listaDirectorio = file.list();

		for (String unaEntrada : listaDirectorio) {
			System.out.println("Procesando la Entrada: " + unaEntrada);
			mostrarEntrada(unaEntrada);
		}

	}

	public static void mostrarEntrada(String unaEntrada) {
		File fileNew = new File(RUTA_BASE + "/" + unaEntrada);
		if (fileNew.isFile()) {
			System.out.println(
					"El archivo: " + unaEntrada + ((fileNew.canRead()) ? "Se puede leer" : "No se puede leer"));
			System.out.println("El archivo: " + unaEntrada
					+ ((fileNew.canWrite()) ? "Se puede escribir" : "No se puede escribir"));
			System.out.println("El archivo: " + unaEntrada
					+ ((fileNew.canExecute()) ? "Se puede ejecutar" : "No se puede ejecutar"));
			System.out.println("El archivo: " + unaEntrada + ((fileNew.isHidden()) ? "Es oculto" : "No Es oculto"));
		} else if (fileNew.isDirectory()) {
			String[] lista = fileNew.list();
			for (String entradaDirectorio : lista) {
				System.out.println("En el directorio: " + unaEntrada
						+ ". Tiene: " + entradaDirectorio);
			}
		} else {
			System.out.println("No es posible saber que es: " + unaEntrada);
		}
	}

}
