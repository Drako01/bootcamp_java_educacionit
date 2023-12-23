package com.educacionit.desafio_05;

import java.util.Scanner;

public class MainOracion extends AnalizadorOracion {
    public MainOracion(String oracion) {
        super(oracion);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String oracion = "";
        while (oracion.isEmpty()) {
            System.out.print("Indique la oración a Evaluar [No debe estar vacía]: ");
            oracion = scanner.nextLine();
        }

        AnalizadorOracion analizador = new AnalizadorOracion(oracion);

        analizador.encontrarCaracterMasRepetido();

        scanner.close();
    }
}