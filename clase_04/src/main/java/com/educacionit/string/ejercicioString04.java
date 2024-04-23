package com.educacionit.string;

public class ejercicioString04 {

	public static void main(String[] args) {
		String miCadena = ".[123].";
		
		int indiceInicial = miCadena.indexOf("[");
		
		int indiceFinal = miCadena.indexOf("]");

		System.out.println("indiceInicial " + (indiceInicial + 1));
		System.out.println("indiceFinal " + (indiceFinal - 1));
		
		String cadenaNumerica = miCadena.substring(2 , 5);
		System.out.println("cadenaNumerica " + cadenaNumerica);		
		
	}

}
