package com.educacionit.cola;

import com.educacionit.cola.exception.ColaException;

public class Cola<T> {

	private T[] elementos;
	private int capacidad;
	private int inicio;
	private int tamanio;

	public Cola(int capacidad) {
		this.capacidad = capacidad;
		elementos = (T[]) new Object[capacidad];
		inicio = 0;
		tamanio = 0;
	}

	public T desencolar() {
		if (estaVacia()) {
			throw new ColaException("La Cola esta Vacía.!");
		}
		T elemento = elementos[inicio];
		inicio++;
		tamanio--;

		return elemento;
	}

	public void encolar(T elemento) throws ColaException {
		if (tamanio == capacidad) {
			throw new ColaException("La Cola esta llena.!");
		}

		elementos[tamanio] = elemento;
		tamanio++;

	}

	public boolean estaVacia() {
		return tamanio == 0;
	}

	public T primero() {
		if (estaVacia()) {
			throw new ColaException("La Cola esta Vacía.!");
		}
		return elementos[inicio];
	}

	public int tamanio() {
		return tamanio;
	}

}
