package com.educacionit;

import java.util.Scanner;

public class ejercicioScanner02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double grados;
		double gradosF;
		System.out.println("Ingrese los Grados: ");

		grados = scanner.nextDouble();
		gradosF = 32 + (9 * grados / 5);

		System.out.println(grados + " Grados Centígrados, equivalen a " + gradosF + " Grados Fahrenheit");
		scanner.close();
	}

}
