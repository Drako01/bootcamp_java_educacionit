package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class PilaArray <E> {

	private E[] pila;
	private int contador;

	public PilaArray() {
	}
	
	public PilaArray(int capacidad) {
		this.pila = (E[]) new Integer[capacidad];
		this.contador = 0;

	}

	public boolean estaVacia() {

		if (contador == 0) {
			return true;
		}
		
		return false;

	}

	public boolean aniadir(E elemento) {
		if (contador == pila.length) {
			return false;
		}

		pila[contador] = elemento;
		contador++;

		return true;
	}

	public E extraer() throws NoExisteElementoException {
		if (contador == 0) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}

		E valorARetornar = pila[contador - 1];
		contador--;
		return valorARetornar;
	}

	public E primero() throws NoExisteElementoException {
		if (contador == 0) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}
		E primerElementoARetornar = pila[contador - 1];
		return primerElementoARetornar;
	}

}
