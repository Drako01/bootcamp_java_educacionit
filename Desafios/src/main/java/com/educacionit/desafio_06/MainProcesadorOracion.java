package com.educacionit.desafio_06;

import java.util.Scanner;

public class MainProcesadorOracion extends ProcesadorOracion {

	public MainProcesadorOracion(String oracion) {
		super(oracion);
	}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Indique la oracion a evaluar (No puede estar vacia): ");

        String oracion = scanner.nextLine().trim();        

        MainProcesadorOracion procesador = new MainProcesadorOracion(oracion);

        procesador.contarPalabras();
        procesador.verificarPalabrasRepetidas();
        procesador.ordenarPalabrasAscendente();
        procesador.ordenarLetras();
        
        scanner.close();
    }

}
