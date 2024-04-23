package com.educacionit.pila;

import com.educacionit.pila.exception.NoExisteElementoException;

public class PilaGenericosTest {

	public static void main(String[] args) {
		PilaArray<String> pila = new PilaArray<>(5);

		pila.aniadir("Integer.valueOf(10)");
		try {
			
			String unString = pila.extraer();
			System.out.println("El alumno es: " + unString);
			
		} catch (NoExisteElementoException e) {
			e.printStackTrace();
		}
		
		PilaArray<Float> pilaFloat = new PilaArray<>(5);
		pilaFloat.aniadir(Float.valueOf(9));
		
		PilaArray<Alumno> pilaAlumno = new PilaArray<>(5);
		Alumno unAlumno = new Alumno();
		pilaAlumno.aniadir(unAlumno);
		
		
		
	}

}
