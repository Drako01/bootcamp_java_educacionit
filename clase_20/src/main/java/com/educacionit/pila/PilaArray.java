package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class PilaArray {

	private Integer[] pila;
	private int contador;

	public PilaArray(int capacidad) {
		this.pila = new Integer[capacidad];
		this.contador = 0;

	}

	public boolean estaVacia() {

		if (contador == 0) {
			return true;
		}
		
		return false;

	}

	public boolean aniadir(Integer elemento) {
		if (contador == pila.length) {
			return false;
		}

		pila[contador] = elemento;
		contador++;

		return true;
	}

	public Integer extraer() throws NoExisteElementoException {
		if (contador == 0) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}

		Integer valorARetornar = pila[contador - 1];
		contador--;
		return valorARetornar;
	}

	public Integer primero() throws NoExisteElementoException {
		if (contador == 0) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}
		Integer primerElementoARetornar = pila[contador - 1];
		return primerElementoARetornar;
	}

}
