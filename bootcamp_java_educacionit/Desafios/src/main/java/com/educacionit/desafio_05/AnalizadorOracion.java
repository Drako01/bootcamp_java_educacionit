package com.educacionit.desafio_05;
//Ejercicio_02

import java.util.Scanner;

class AnalizadorOracion {
    private String oracion;

    public AnalizadorOracion(String oracion) {
        this.oracion = oracion;
    }

    public void encontrarCaracterMasRepetido() {
        String oracionSinEspacios = oracion.replace(" ", "");

        while (oracionSinEspacios.isEmpty()) {
            System.out.print("Indique la oración a Evaluar [No debe estar vacía]: ");
            Scanner scanner = new Scanner(System.in);
            oracion = scanner.nextLine();
            oracionSinEspacios = oracion.replace(" ", "");
            scanner.close();
        }

        char caracterMasRepetido = encontrarCaracterMasRepetidoEnOracion(oracionSinEspacios);
        int numeroDeVeces = contarRepeticiones(caracterMasRepetido, oracionSinEspacios);
        
        System.out.println("El carácter [" + caracterMasRepetido + "] se Repite " +
        		numeroDeVeces + " veces.");
    }

    private char encontrarCaracterMasRepetidoEnOracion(String oracion) {
        char caracterMasRepetido = '\0';
        int maxRepeticiones = 0;

        for (int i = 0; i < oracion.length(); i++) {
            char caracterActual = oracion.charAt(i);
            int repeticionesActual = contarRepeticiones(caracterActual, oracion);

            if (repeticionesActual > maxRepeticiones) {
                maxRepeticiones = repeticionesActual;
                caracterMasRepetido = caracterActual;
            }
        }

        return caracterMasRepetido;
    }

    private int contarRepeticiones(char caracter, String oracion) {
        int contador = 0;

        for (int i = 0; i < oracion.length(); i++) {
            if (oracion.charAt(i) == caracter) {
                contador++;
            }
        }

        return contador;
    }
}

