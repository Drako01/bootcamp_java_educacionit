package com.educacionit.consola;

public class Consola {

	public static void main(String[] args) {
		int cantidadDeArgumentos = args.length;
		System.out.println("La cantidad de parámetros recibidos son: " + cantidadDeArgumentos);

		if(cantidadDeArgumentos == 1) {
			System.out.println("out - Se llamo con un solo parametro: " + args[0]);
			System.err.println("arr - Se llamo con un solo parametro: " + args[0]);
		} else if (cantidadDeArgumentos == 0) {
			System.out.println("Se llamo sin parametros - out" );
			System.err.println("Se llamo sin parametros - err");
		}
	}

}
