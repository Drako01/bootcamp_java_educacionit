package com.educacionit.desafio_08.ejercicio_02;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.educacionit.desafio_08.ejercicio_02.controller.DAOController;
import com.educacionit.desafio_08.ejercicio_02.exceptions.DBManagerException;
import com.educacionit.desafio_08.ejercicio_02.models.Provincia;

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
					System.out.println("Menú: \n " 
								+ "1. Buscar Alguna Provincia\n " 
								+ "2. Listar todas las Provincias\n " 
								+ "3. Listar todos los Paíces\n " 
								+ "4. Agregar una Nueva Provincia\n " 
								+ "5. Modificar una Provincia por ID\n " 
								+ "6. Eliminar una Provincia por ID\n " 
								+ "0. Salir\n ");

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
					case 2:
					    dao.mostrarTodasLasProvincias();
					    break;
					case 3:
						dao.mostrarTodosLosPaises();
						break;
					case 4:
					    try {
					        System.out.println("Ingrese una Descripcion para la Provincia: ");
					        String descripcionProvincia = scanner.nextLine();
					        
					        System.out.println("Seleccione un ID de Pais a partir de la Siguiente lista: ");
					        dao.mostrarTodosLosPaises();
					        
					        System.out.println("Ingrese el ID de Pais: ");
					        int idPais = scanner.nextInt();
					        scanner.nextLine(); 
					        
					        Provincia nuevaProvincia = new Provincia();
					        nuevaProvincia.setDescripcion(descripcionProvincia);
					        nuevaProvincia.setPaisId(idPais);
					        
					        dao.insertarProvincia(nuevaProvincia);					        
					        
					    } catch (InputMismatchException e) {
					        System.out.println("Error: Ingrese un número válido.");
					        scanner.nextLine(); 
					    } 
					    break;

					case 5:					    
					    System.out.println("Seleccione un ID de una Provincia a partir de la Siguiente lista: ");
					    dao.mostrarTodasLasProvincias();
					    System.out.println("Ingrese el ID de la Provincia: ");
					    int idProvincia = scanner.nextInt();
					    scanner.nextLine();  

					    System.out.println("Ingrese la nueva descripción de la Provincia: ");
					    String nuevaDescripcion = scanner.nextLine();

					    System.out.println("Ingrese el nuevo ID del País (deje vacío si no desea cambiar): ");
					    String nuevoIdPaisStr = scanner.nextLine();
					    Integer nuevoIdPais = null;
					    if (!nuevoIdPaisStr.isEmpty()) {
					        try {
					            nuevoIdPais = Integer.parseInt(nuevoIdPaisStr);
					        } catch (NumberFormatException e) {
					            System.out.println("Error: Formato de ID de país no válido. Se omitirá el cambio de ID de país.");
					        }
					    } else {					       
					        nuevoIdPais = dao.obtenerIdPaisPorProvincia(idProvincia);
					    }

					    Provincia provinciaEditada = new Provincia(idProvincia, nuevaDescripcion, nuevoIdPais);

					    try {
					        dao.editarProvincia(provinciaEditada);
					    } catch (DBManagerException e) {
					        System.out.println("Error al editar la provincia: " + e.getMessage());
					    }
					    break;



					case 6:
						 System.out.println("Seleccione un ID de una Provincia a partir de la Siguiente lista: ");
						   dao.mostrarTodasLasProvincias();
						   System.out.println("Ingrese el ID de la Provincia: ");
						   Integer idProvinciaEliminar  = scanner.nextInt();
						   scanner.nextLine();
						   try {
						        dao.eliminarProvincia(idProvinciaEliminar);						       
						    } catch (DBManagerException e) {
						        System.out.println("Error al eliminar la provincia: " + e.getMessage());
						    }
						   
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
