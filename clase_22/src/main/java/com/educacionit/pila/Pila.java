package com.educacionit.pila;

import java.util.ArrayDeque;
import java.util.Deque;

import com.educacionit.pila.exception.NoExisteElementoException;

public class Pila<E> {

	private Deque<E> pila = new ArrayDeque<E>();

	public Pila() {
	}

	public boolean estaVacia() {

		return pila.isEmpty();

	}

	public void aniadir(E elemento) {
		pila.push(elemento);
	}

	public E extraer() throws NoExisteElementoException {
		if (estaVacia()) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}
		return pila.pop();
	}

	public E primero() throws NoExisteElementoException {
		if (estaVacia()) {
			throw new NoExisteElementoException("La pila se encuentra Vacia");
		}
		return pila.peek();
	}
	
	public int tamanio() {
		return pila.size();
	}

}
