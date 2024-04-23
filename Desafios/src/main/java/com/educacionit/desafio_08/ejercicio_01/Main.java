package com.educacionit.desafio_08.ejercicio_01;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.educacionit.desafio_08.ejercicio_01.controller.DAOController;
import com.educacionit.desafio_08.ejercicio_01.exceptions.DBManagerException;

public class Main {

	public static void main(String[] args) throws DBManagerException {

		mostrarMenu();

	}

	public static void mostrarMenu() {
		DAOController dao = new DAOController();
		try {
			Scanner scanner = new Scanner(System.in);

			int opcion = -1;

			do {
				try {
					System.out.println("Menú: \n " + "1. Buscar Alguna Provincia\n " + "0. Salir\n ");

					System.out.print("Ingrese su opción: ");

					if (scanner.hasNextInt()) {
						opcion = scanner.nextInt();
						scanner.nextLine();
					} else {
						System.out.println("Entrada inválida. Debe ingresar un número.");
						scanner.nextLine();
						continue;
					}

					switch (opcion) {
					case 1:
						System.out.println("Ingrese una Provincia o parte de su descripción: ");
						String provinciaBusqueda = scanner.nextLine();
						dao.mostrarProvinciasPorDescripcion(provinciaBusqueda);
						break;

					case 0:
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción inválida. Por favor, " + "ingrese una opción válida.");
						break;
					}

				} catch (InputMismatchException e) {
					System.out.println("Error: Ingrese un número válido.");
					scanner.nextLine();
					opcion = -1;
				}

			} while (opcion != 0);

			scanner.close();

		} catch (Exception e) {
			e.getMessage();

		}

	}

}
