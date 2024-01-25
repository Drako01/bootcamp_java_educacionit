package com.educacionit.casteo;

public class Ejercicio01_Casteo {

	public static void main(String[] args) {
		int unInt = 10;
		double unDouble;
		// float unFloat;
		// long unLong;
		short unShort;

		unDouble = unInt; // (Casteo Implícito)
		// unFloat = unInt; // IDEM
		// unLong = unInt; // IDEM
		unShort = (short) unInt; // No se puede Castear Implicitamente > Se castea Explicitamente con ()

		unDouble = 2.56;
		unShort = (short) unDouble;

		System.out.printf("Valor Double: %.2f - Valor Short: %d\n", unDouble, unShort); // Se pierde toda la parte
																						// Decimal

		short s = 149;
		byte b = (byte) s;
		if (s > 129) {
			System.out.println("No deberia castear");
		} else {
			System.out.println("Short: " + s + " - Valor Byte: " + b);
		}
	}

}
