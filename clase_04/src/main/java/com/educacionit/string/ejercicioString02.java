package com.educacionit.string;

public class ejercicioString02 {

	public static void main(String[] args) {
		String miCadena = "Apellido, PrimerNombre, SegundoNombre";
		String[] resultaDelSplit = miCadena.split(",");
		String apellido = resultaDelSplit[0];
		apellido = apellido.toUpperCase(); //Los String son inmutables
		System.out.println("El Apellido es: " + apellido);
		//Otra Forma
		System.out.println("El Apellido es: " + resultaDelSplit[0].toUpperCase());
		System.out.printf("El Primer Nombre es: [%s] - [%s]\n", resultaDelSplit[1].toLowerCase(), (resultaDelSplit[1].toLowerCase()).trim());
		System.out.printf("El Segundo Nombre es: \"%s\"", resultaDelSplit[2]);
		String segundoNombre = resultaDelSplit[2].trim();
		//segundoNombre = segundoNombre.trim();
		System.out.printf("\nEl Segundo Nombre es: \"%s\"", segundoNombre);
	}

}
