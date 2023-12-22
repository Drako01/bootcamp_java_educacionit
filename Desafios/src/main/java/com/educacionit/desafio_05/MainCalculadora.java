package com.educacionit.desafio_05;

import java.util.Scanner;

public class MainCalculadora extends CalculadoraNumeros {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculadoraNumeros calculadora = new CalculadoraNumeros();

        while (true) {
            try {
                System.out.print("Para culminar escriba 0 de lo contrario escriba cualquier numero: ");
                int numero = Integer.parseInt(scanner.nextLine());

                if (numero == 0) {
                    break;
                }

                calculadora.procesarNumero(numero);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número entero válido.");
            }
        }

        System.out.println("\nLa Suma Total es: " + calculadora.obtenerSuma());
        System.out.println("El Número mayor ingresado: " + calculadora.obtenerNumeroMayor());
        System.out.println("El Número menor ingresado: " + calculadora.obtenerNumeroMenor());
        
        scanner.close();
    }

}
