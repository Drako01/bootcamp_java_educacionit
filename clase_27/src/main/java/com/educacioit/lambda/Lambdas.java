package com.educacioit.lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

	public void ejercicio01() {

		BinaryOperator<Integer> suma = (x, y) -> x + y;

		Integer resultado = suma.apply(10, 20);
		System.out.println("El resultado es: " + resultado);
	}

	public void ejercicio02() {

		BinaryOperator<Integer> multiplicacion = (x, y) -> x * y;

		Integer resultado = multiplicacion.apply(5, 6);
		System.out.println("El resultado es: " + resultado);
	}

	public void ejercicio03() {
		Predicate<Integer> esPar = x -> x % 2 == 0;
		boolean resultado1 = esPar.test(2);
		boolean resultado2 = esPar.test(3);
		System.out.println("El resultado es Par? " + resultado1);
		System.out.println("El resultado es Par? " + resultado2);
	}

	public void ejercicio04() {
		Function<String, Integer> longitudDeString = x -> x.length();
		Integer resultado = longitudDeString.apply("Hola Mundo");
		System.out.println("El String tiene " + resultado + " caracteres");

	}

	public void ejercicio05() {
		Function<String, String> convertirEnMayuscula = cadena -> cadena.toUpperCase();
		String resultado = convertirEnMayuscula.apply("Hola Mundo");
		System.out.println("El String en Mayuscula queda " + resultado);

	}

	public void ejercicio06() {
		Function<Integer, Integer> potencia = x -> x * x;
		Integer resultado = potencia.apply(5);
		System.out.println("El Cuadrado es " + resultado);
	}

	public void ejercicio07() {
		BiFunction<String, String, String> concatenacion = (s1, s2) -> s1 + s2;
		String resultado = concatenacion.apply("Hola ", "Mundo");
		System.out.println("Los String concatenados quedan asi: " + resultado);
	}

	public void ejercicio08() {
		Predicate<String> cadena = x -> x.isEmpty();
		boolean resultadoVacio = cadena.test("");
		boolean resultadoLleno = cadena.test("Hola");
		System.out.println("La cadena es un String vacio? " + resultadoVacio);
		System.out.println("La cadena es un String vacio? " + resultadoLleno);

	}

	public void ejercicio09() {

		BinaryOperator<Integer> maximo = (x, y) -> x > y ? x : y;
		BinaryOperator<Integer> maximo2 = (x, y) -> Math.max(x, y);
		Integer resultado = maximo.apply(5, 6);
		System.out.println("El Máximo es: " + resultado);
		Integer resultado2 = maximo2.apply(9, 6);
		System.out.println("El Máximo es: " + resultado2);
	}

	public void ejercicio10() {

		BinaryOperator<Integer> minimo = (x, y) -> x < y ? x : y;
		BinaryOperator<Integer> minimo2 = (x, y) -> Math.min(x, y);
		Integer resultado = minimo.apply(5, 6);
		System.out.println("El Minimo es: " + resultado);
		Integer resultado2 = minimo2.apply(9, 6);
		System.out.println("El Minimo es: " + resultado2);
	}

	public void ejercicio11() {
		Consumer<String> imprimirMensaje = mensaje -> System.out.println(mensaje);
		imprimirMensaje.accept("Este es el Mensaje!");
	}

	public void ejercicio12() {
		Predicate<Integer> esPositivo = x -> x > 0;
		boolean resultado1 = esPositivo.test(2);
		boolean resultado2 = esPositivo.test(3);
		System.out.println("El Positivo es Par? " + resultado1);
		System.out.println("El Positivo es Par? " + resultado2);
	}

	public void ejercicio13() {
		Function<Double, Double> areaCirculo = x -> Math.PI * x * x;
		Double resultado = areaCirculo.apply(5.0d);
		System.out.println("El Area del Circulo es " + resultado);
		Function<Double, Double> areaCirculo1 = x -> Math.PI * Math.pow(x, 8d);
		Double resultado1 = areaCirculo1.apply(5.0d);
		System.out.println("El Area del Circulo es " + resultado1);
	}

	public void ejercicio14() {
		BiFunction<Integer, Integer, Double> potencia = (base, exponente) -> Math.pow(base, exponente);
		Double resultado = potencia.apply(5, 2);
		System.out.println("Los String concatenados quedan asi: " + resultado);
	}

	public void ejercicio15() {
		Function<Double, Integer> parteEntera = x -> {
			System.out.println("Uso Return dentro de Lambda");
			return x.intValue();
		};

		Integer resultado = parteEntera.apply(5.6);
		System.out.println("La parte entera es " + resultado);
	}

	public void ejercicio16() {
		Function<Integer, Integer> elDoble = x -> x * 2;
		Integer resultado = elDoble.apply(15);
		System.out.println("El Doble es " + resultado);
	}

	public void ejercicio17() {
		BiFunction<String, String, Boolean> tieneSubCadena = (cadena, subcadena) -> cadena.contains(subcadena);
		Boolean resultado = tieneSubCadena.apply("Hola", "ol");
		System.out.println("El String contiene SubCadena?: " + resultado);
	}

	public void ejercicio18() {
		BiFunction<Integer, Integer, Integer> modulo = (n1, n2) -> n1 % n2;
		Integer resultado = modulo.apply(5, 2);
		System.out.println("El Modulo es: " + resultado);
	}
}
