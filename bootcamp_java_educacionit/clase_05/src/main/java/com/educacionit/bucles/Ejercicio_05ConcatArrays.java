package com.educacionit.bucles;

public class Ejercicio_05ConcatArrays {

	public static void main(String[] args) {

		char[] arrayUno = { 'H', 'o', 'l', 'a' };
		int[] arrayDos = { ' ', 'M', 'u', 'n', 'd', 'o' };

		char[] arrayResuelto = concatenarArrays(arrayUno, arrayDos);

		System.out.println("Array Concatenado: " + new String(arrayResuelto));
	}

	public static char[] concatenarArrays(char[] array1, int[] array2) {

		int longitudTotal = array1.length + array2.length;

		char[] arrayResuelto = new char[longitudTotal];

		for (int i = 0; i < array1.length; i++) {
			arrayResuelto[i] = array1[i];
		}

		for (int i = 0; i < array2.length; i++) {
			arrayResuelto[array1.length + i] = (char) array2[i];
		}

		return arrayResuelto;
	}

}
