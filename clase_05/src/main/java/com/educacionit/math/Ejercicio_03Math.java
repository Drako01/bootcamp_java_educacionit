package com.educacionit.math; //Math no se Importa porque esta dentro del Paquete java.lang

public class Ejercicio_03Math {

	public static void main(String[] args) {
		double unDouble = 9.0;
		
		double resultado = Math.sqrt(unDouble);
		System.out.println("Raiz cuadrada de " + unDouble + " es: " + resultado);
		
		double resultado1 = Math.cbrt(unDouble);
		System.out.println("Raiz cubica de " + unDouble + " es: " + resultado1);
		
		

	}

}
