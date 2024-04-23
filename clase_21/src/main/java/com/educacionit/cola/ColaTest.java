package com.educacionit.cola;

public class ColaTest {

	public static void main(String[] args) {
		
		Cola<String> cola = new Cola<>(5);
		
		cola.encolar("P1");
		cola.encolar("P2");
		cola.encolar("P3");
		
		/*String unString1 = cola.desencolar(); //P1
		String unString2 = cola.desencolar(); //P2
		String unString3 = cola.desencolar(); //P3*/
		
		System.out.println("El 1er Elemento de la Cola es de: " + cola.primero());
		System.out.println("El tamaño de la Cola es de: " + cola.tamanio());
		
		while (!cola.estaVacia()) {
			String ele = cola.desencolar();
			System.out.println("Elemento desencolado: " + ele);
		}
	}

}
