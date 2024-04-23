package com.educacionit.desafio_05;

import java.util.Scanner;

public class MainCalculadora extends CalculadoraNumeros {

    public MainCalculadora() {
        super();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculadoraNumeros calculadora = new CalculadoraNumeros();

        boolean salir = false;
        
        while (!salir) {
            System.out.print("Para culminar escriba 0 de lo contrario escriba cualquier numero: ");

            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();

                if (numero == 0) {
                    salir = true;
                } else {
                    calculadora.procesarNumero(numero);
                }
            } else {
                scanner.next();
                System.out.println("Error: Ingresa un número entero válido.");
            }
        }

        System.out.println("\nLa Suma Total es: " + calculadora.obtenerSuma());
        System.out.println("El Número mayor ingresado: " + calculadora.obtenerNumeroMayor());
        System.out.println("El Número menor ingresado: " + calculadora.obtenerNumeroMenor());

        scanner.close();
    }
}
