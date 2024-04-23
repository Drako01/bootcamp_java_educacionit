package com.educacionit.desafio_07.desafiojava3.clase;

import java.util.Arrays;

import com.educacionit.desafio_07.desafiojava3.excepcion.NoCapacityException;

public class CollectionCustom<T> {
	private T[] array;
	private int size;
	private static final int DEFAULT_CAPACITY = 4;

	@SuppressWarnings("unchecked")
	public CollectionCustom() {
		this.array = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public void addFirst(T dato) {
		verificarCapacidad();
		if (this.size == 0) {
			this.array[0] = dato;
		} else {
			for (int i = this.size; i > 0; i--) {
				this.array[i] = this.array[i - 1];
			}
			this.array[0] = dato;
		}
		this.size++;
	}

	public void addLast(T dato) {
		verificarCapacidad();
		this.array[this.size++] = dato;
	}

	public void add(T dato) {
		addLast(dato);
	}

	public T remove(T dato) { // Remueve de la lista el primer dato igual al parametro
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(dato)) {
				T removedDato = array[i];
				for (int j = i; j < this.size - 1; j++) {
					this.array[j] = this.array[j + 1];
				}
				this.array[this.size - 1] = null;
				this.size--;
				return removedDato;
			}
		}
		return null;
	}

	public void removeAllWhithDate(T dato) { // Elimina de la Lista todos los elementos iguales al dato que se pasa por parametro
		for (int i = 0; i < this.size; i++) {
			if (this.array[i].equals(dato)) {
				for (int j = i; j < this.size - 1; j++) {
					this.array[j] = this.array[j + 1];
				}
				this.array[this.size - 1] = null;
				this.size--;
				i--;
			}
		}
	}

	public void removeAll() { // Vacia la Lista completa
		for (int i = 0; i < this.size; i++) {
			this.array[i] = null;
		}
		this.size = 0;
	}

	public boolean empty() {
		return this.size == 0;
	}

	private void verificarCapacidad() {
	    if (this.size == this.array.length) {
	        throw new NoCapacityException("No hay capacidad suficiente para agregar más elementos a la lista.");
	    }
	}


	@Override
	public String toString() {
		return "CollectionCustom [array = " + Arrays.toString(array) + ", size = " + size + "]";
	}

}
