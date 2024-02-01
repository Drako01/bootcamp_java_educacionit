package com.educacionit.generics;

public class TestAlumno {

	public static void main(String[] args) {
		Alumno <String, Double> unAlumno = new Alumno <>();
		
		unAlumno.setLegajo("LEG123");
		unAlumno.setPromedio(7.89);
		
		Alumno <Integer, Long> otroAlumno = new Alumno <>();
		
		otroAlumno.setLegajo(Integer.valueOf(1234));
		otroAlumno.setPromedio(Long.valueOf(8));
		
		
	}

}
