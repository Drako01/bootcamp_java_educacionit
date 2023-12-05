package com.educacionit.math;

public class Ejercicio_02Math {

	public static void main(String[] args) {
		double unDouble = 4.2;
		//double unDouble = 4.5;
		//double unDouble = 4.8;
		
		double resultado;
		
		resultado = Math.ceil(unDouble);
		System.out.println("Ceil: " + resultado);
		resultado = Math.floor(unDouble);
		System.out.println("Floor: " + resultado);
		resultado = Math.round(unDouble);
		System.out.println("Round: " + resultado);

	}

}
