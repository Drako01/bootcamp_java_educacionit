package com.educacionit.wrappers;

public class Wrapper {

	public static void main(String[] args) {
		Integer enteroUno = new Integer(1); //Deprecado desde la version 9
		/*Miembros de Clase*/
		Integer enteroDos = Integer.valueOf(2);
		Integer enteroTres = Integer.valueOf("3");

		/*Para todos los Primitivos igual*/
		
		/*Miembre de Instancia*/
		int unEnteroPrimitivo = enteroDos.intValue(); //(int Dato Primitivo)
		
		/***********************************/
		Long longUno = Long.valueOf(1); // Metodo estatico "static"
		try {
			Long longDos = Long.valueOf("Hola");
		} catch (NumberFormatException e) {
			System.err.println("Error de Formato: " + e.getMessage());
		}
		
		/*Boxing*/
		Float unFloat = 1.2f;
		Boolean unBooleano = true;
		
		/*UnBoxing*/
		float unFloatPrimitivo = unFloat;
		boolean unBooleanoPrimitivo = unBooleano;
		
	}

}
