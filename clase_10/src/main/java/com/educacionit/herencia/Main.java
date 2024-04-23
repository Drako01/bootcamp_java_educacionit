package com.educacionit.herencia;

public class Main {

	public static void main(String[] args) {
		Yogur yogur = new Yogur();
		System.out.println(yogur.consultarCalorias());

		YogurDescremado yogurDescremado = new YogurDescremado();
		System.out.println(yogurDescremado.consultarCalorias());

	}

}
