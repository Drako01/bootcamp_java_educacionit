package com.educacionit.bucles;

public class Ejercicio_05ConcatArrays {

	public static void main(String[] args) {
      
        char[] arrayUno = {'H', 'o', 'l', 'a'};
        int[] arrayDos = {' ', 'M', 'u', 'n', 'd', 'o'};

       char[] arrayResuelto = concatenarArrays(arrayUno, arrayDos);
        
        System.out.println("Array Concatenado: " + new String(arrayResuelto));
    }
    
    public static char[] concatenarArrays(char[] arr1, int[] arr2) {
        
        int longitudTotal = arr1.length + arr2.length;
       
        char[] arrayResuelto = new char[longitudTotal];
       
        for (int i = 0; i < arr1.length; i++) {
            arrayResuelto[i] = arr1[i];
        }

       
        for (int i = 0; i < arr2.length; i++) {
            arrayResuelto[arr1.length + i] = (char) arr2[i];
        }

        return arrayResuelto;
    }

}
