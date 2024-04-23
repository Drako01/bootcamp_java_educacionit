package com.educacionit.string;

public class ejercicioString01 {

	public static void main(String[] args) {
		String miCadena = "Hola Mundo!";
		
		int longitudDeLaCadena;
		
		longitudDeLaCadena = miCadena.length();
		System.out.println("La longitud de la cadena es de: " + miCadena.length() + " caracteres");
		//Otra forma es:
		System.out.println("La longitud de la cadena es de: " + longitudDeLaCadena + " caracteres");
		
		System.out.println("Posicion del caracter H: " + miCadena.indexOf("H"));
		System.out.println("Posicion de la cadena Mundo: " + miCadena.indexOf("Mundo"));
		char posicionChar = miCadena.charAt(1);
		System.out.println("El caracter que esta en la Posicion 2 es: " + posicionChar);
		//Otra forma es:
		System.out.println("El caracter que esta en la Posicion 2 es: " + miCadena.charAt(1));
	}

}
