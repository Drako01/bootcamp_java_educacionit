package com.educacionit.ejercicio01;

import java.util.List;

public class CalcularFormas {

	public static <T extends Forma> void calcular(List<T> listaFormas) {

		// Foreach
		for (T unaForma : listaFormas) {
			double area = unaForma.calcularArea();
			double perimetro = unaForma.calcularPerimetro();
			
			System.out.println("Objeto : " + unaForma);
			System.out.println("Area: " + area);
			System.out.println("Perimetro: " + perimetro);
			System.out.println();
		}

		/*
		// for tradicional
		for (int i = 0; i < listaFormas.size(); i++) {
			Forma unaForma = listaFormas.get(i);
			double area = unaForma.calcularArea();
			double perimetro = unaForma.calcularPerimetro();

			System.out.println("Area: " + area);
			System.out.println("Perimetro: " + perimetro);

		}*/

	}

}
