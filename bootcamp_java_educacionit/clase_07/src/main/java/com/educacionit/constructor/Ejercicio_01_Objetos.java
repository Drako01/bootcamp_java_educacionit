package com.educacionit.constructor;

public class Ejercicio_01_Objetos {

	public static void main(String[] args) {
		ArticuloCientifico articuloCientifico = new ArticuloCientifico("Titulo del Articulo Cientifico", "Alejandro");
		
		String tituloEnMain = articuloCientifico.getTitulo();
		
		System.out.println("Valor de Titulo: " + tituloEnMain);
		
	}

}
