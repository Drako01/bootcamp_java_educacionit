package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class Depurar {

	public static void main(String[] args)  throws NoExisteElementoException{
		PilaArray miPila = new PilaArray(3);
		
		Integer unEntero = 1000;
		boolean pudoAniadir = miPila.aniadir(unEntero);
		System.out.println("Pudo añadir: " + pudoAniadir);

		Integer enteroExraido = miPila.extraer();
		Integer enteroExraido2 = miPila.extraer();
		
	}

}
