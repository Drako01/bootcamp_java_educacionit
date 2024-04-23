package com.educacionit.desafio_07.desafiojava1.clases;

public class Alumno {

	private String nombre;
	private String apellido;
	private int[] numerosDeExamen;
	private double[] notas;

	public Alumno(String nombre, String apellido, int cantidadExamenes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numerosDeExamen = new int[cantidadExamenes];
		this.notas = new double[cantidadExamenes];
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int[] getNumerosDeExamen() {
		return this.numerosDeExamen;
	}

	public void setNumerosDeExamen(int[] numerosDeExamen) {
		this.numerosDeExamen = numerosDeExamen;
	}

	public double[] getNotas() {
		return this.notas;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}

	public double calcularPromedio() {
		double suma = 0;
		for (double nota : this.notas) {
			suma += nota;
		}
		return suma / this.notas.length;
	}

	@Override
	public String toString() {
		return "Alumno [Nombre= " + nombre + ", Apellido= " + apellido + ", Promedio= " + calcularPromedio() + "]";
	}

}
