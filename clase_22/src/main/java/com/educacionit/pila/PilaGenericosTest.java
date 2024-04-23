package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class PilaGenericosTest {

	public static void main(String[] args) throws NoExisteElementoException {
		Pila<String> pila = new Pila<>();

		pila.aniadir("P1");
		pila.aniadir("P2");
		pila.aniadir("P3");

		while (!pila.estaVacia()) {
			System.out.println("El tamaño de la Cola es de: " + pila.tamanio());
			System.out.println("El 1er Elemento de la Cola es de: " + pila.primero());
			System.out.println("Elemento desencolado: " + pila.extraer() + "\n");
		}

	}

}
