package com.educacionit.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class TestFormas {

	public static void main(String[] args) {
		
		List<Forma> listaFormas = new ArrayList<>();
		
		Circulo unCirculo = new Circulo(20d);
		Rectangulo unRectangulo = new Rectangulo(1d, 2d);
		Triangulo unTriangulo = new Triangulo(1d,2d,3d);
		
		listaFormas.add(unCirculo);
		listaFormas.add(unRectangulo);
		listaFormas.add(unTriangulo);
		
		CalcularFormas.calcular(listaFormas);
		
	}

}
