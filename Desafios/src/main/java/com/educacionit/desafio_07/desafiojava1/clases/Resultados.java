package com.educacionit.desafio_07.desafiojava1.clases;

import java.util.ArrayList;
import java.util.List;

public class Resultados {

	public static List<Alumno> encontrarCalificacionMasAlta(Alumno[] alumnos) {
		List<Alumno> mejoresAlumnos = new ArrayList<>();
		double maxPromedio = 0;

		for (Alumno alumno : alumnos) {
			double promedio = alumno.calcularPromedio();
			maxPromedio = Math.max(maxPromedio, promedio);
		}

		for (Alumno alumno : alumnos) {
			if (alumno.calcularPromedio() == maxPromedio) {
				mejoresAlumnos.add(alumno);
			}
		}

		return mejoresAlumnos;
	}

	public static List<Alumno> encontrarCalificacionMasBaja(Alumno[] alumnos) {
		List<Alumno> peoresAlumnos = new ArrayList<>();
		double minPromedio = 10;

		for (Alumno alumno : alumnos) {
			double promedio = alumno.calcularPromedio();
			minPromedio = Math.min(minPromedio, promedio);
		}

		for (Alumno alumno : alumnos) {
			if (alumno.calcularPromedio() == minPromedio) {
				peoresAlumnos.add(alumno);
			}
		}

		return peoresAlumnos;
	}

	public static List<Alumno> encontrarAlumnosPromocionan(Alumno[] alumnos) {
		List<Alumno> alumnosPromocion = new ArrayList<>();

		for (Alumno alumno : alumnos) {
			if (alumno.calcularPromedio() >= 7) {
				alumnosPromocion.add(alumno);
			}
		}

		return alumnosPromocion;
	}

	public static List<Alumno> encontrarAlumnosRecursar(Alumno[] alumnos) {
		List<Alumno> alumnosRecursar = new ArrayList<>();

		for (Alumno alumno : alumnos) {
			if (alumno.calcularPromedio() < 7) {
				alumnosRecursar.add(alumno);
			}
		}

		return alumnosRecursar;
	}
}
