package com.educacionit.desafio_05a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProcesadorOracion {

    protected String oracion;

    public ProcesadorOracion(String oracion) {
        this.oracion = oracion;
    }

    public void contarPalabras() {
        String[] palabras = oracion.split("\\s+");
        System.out.println("La cantidad de palabras que contiene la oraciones: " + palabras.length);
    }

    public void verificarPalabrasRepetidas() {
        String[] palabras = oracion.toLowerCase().replaceAll("[^a-zA-Záéíóúüñ]", " ").split("\\s+");
        Map<String, Integer> contadorPalabras = new HashMap<>();

        for (String palabra : palabras) {
            contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
        }

        boolean hayRepetidas = contadorPalabras.values().stream().anyMatch(cantidad -> cantidad > 1);
        System.out.println(hayRepetidas ? "Hay palabras repetidas" : "No hay palabras repetidas");
    }

    
    public void ordenarPalabrasAscendente() {
        String[] palabras = oracion.split("\\s+");
        Arrays.sort(palabras);
        System.out.println("Palabras ordenadas de forma ascendente: \n" + Arrays.toString(palabras));
    }

    
    public void ordenarLetras() {
        char[] letras = oracion.replaceAll("\\s", "").toCharArray();
        Arrays.sort(letras);
        System.out.print("Letras Ordenadas: \n[");
        for (int i = 0; i < letras.length; i++) {
            System.out.print(letras[i]);
            if (i < letras.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
