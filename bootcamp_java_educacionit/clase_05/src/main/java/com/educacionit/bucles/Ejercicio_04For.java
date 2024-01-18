package com.educacionit.bucles;

public class Ejercicio_04For {
	
    public static void main(String[] args) {
        
        String cadena = "x87y5z";        
        char[] numeros = obtenerNumeros(cadena);
       
        System.out.println("Array de números: " + new String(numeros));
        System.out.println("Longitud del array: " + numeros.length);
    }

   
    public static char[] obtenerNumeros(String cadena) {      
        int contadorNumeros = 0;      
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter)) {
                contadorNumeros++;
            }
        }       
        char[] numeros = new char[contadorNumeros];        
        int indice = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter)) {
                numeros[indice] = caracter;
                indice++;
            }
        }

        return numeros;
    }
}
