package com.educacionit.cola;

public class ColaTest {

	public static void main(String[] args) {
		
		Cola<String> cola = new Cola<>();
		
		cola.encolar("P1");
		cola.encolar("P2");
		cola.encolar("P3");		
		
		while (!cola.estaVacia()) {
			System.out.println("El tamaño de la Cola es de: " + cola.tamanio());
			System.out.println("El 1er Elemento de la Cola es de: " + cola.primero());			
			System.out.println("Elemento desencolado: " + cola.desencolar() + "\n");
			
		}
	}

}
