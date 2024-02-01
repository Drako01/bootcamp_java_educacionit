package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class TestPilaArray {

	public static void main(String[] args) throws NoExisteElementoException {
		PilaArray miPila = new PilaArray(3);

		Integer enteroUno = 30;
		Integer enteroDos = Integer.valueOf(20);
		Integer enteroTres = Integer.parseInt("45");

		Boolean aniadioElemento = false;

		aniadioElemento = miPila.aniadir(enteroUno);

		System.out.println("Pude añadir de forma correcta el entero : " + aniadioElemento);

		miPila.aniadir(enteroDos);

		System.out.println("Pude añadir de forma correcta el entero : " + aniadioElemento);

		miPila.aniadir(enteroTres);

		System.out.println("Pude añadir de forma correcta el entero : " + aniadioElemento);

		aniadioElemento = miPila.aniadir(Integer.valueOf(20));

		System.out.println("Pude añadir de forma correcta el entero : " + aniadioElemento);

		Integer valorExtraido = miPila.extraer();
		System.out.println("El Valor extraido de La Pila es: " + valorExtraido);

		try {
			Integer ultimoEnteroAgregado = miPila.primero();
			System.out.println("El Ultimo elemento de La Pila es: " + ultimoEnteroAgregado);
		} catch (NoExisteElementoException e) {
			System.out.println("No puedo recuperar el Ultimo elemento de La Pila");
		}

		valorExtraido = miPila.extraer();
		System.out.println("El Valor extraido de La Pila es: " + valorExtraido);

		try {
			Integer ultimoEnteroAgregado = miPila.primero();
			System.out.println("El Ultimo elemento de La Pila es: " + ultimoEnteroAgregado);
		} catch (NoExisteElementoException e) {
			System.out.println("No puedo recuperar el Ultimo elemento de La Pila");
		}
		valorExtraido = miPila.extraer();
		System.out.println("El Valor extraido de La Pila es: " + valorExtraido);

		try {
			Integer ultimoEnteroAgregado = miPila.primero();
			System.out.println("El Ultimo elemento de La Pila es: " + ultimoEnteroAgregado);
		} catch (NoExisteElementoException e) {
			System.out.println("No puedo recuperar el Ultimo elemento de La Pila");
		}

	}

}
