package com.educacionit;

public class Ejercicio_04_For {

	public static void main(String[] args) throws InterruptedException {
		for (int hora = 0; hora < 24; hora++) {
			for (int minutos = 0; minutos < 60; minutos++) {
				for (int segundos = 0; segundos < 60; segundos++) {
					System.out.println(hora + ":" + minutos + ":" + segundos);
					Thread.sleep(1000); //Milisegundos
				}
			}
		}

	}

}
