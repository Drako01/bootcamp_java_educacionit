package com.educacionit.math;

import java.util.Scanner;

public class Ejercicio_01Math {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese el Radio de un Circulo: ");
		double valorRadio = scanner.nextDouble();
		
		double areaCirculo = Math.PI * Math.pow(valorRadio, 2);
		
		System.out.printf("El area del Circulo con Radio %.5f es: %.5f\n", valorRadio, areaCirculo);
		scanner.close();
	}

}
