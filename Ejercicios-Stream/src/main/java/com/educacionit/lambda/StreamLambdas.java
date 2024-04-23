package com.educacionit.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLambdas {

	public void ejercicio01() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("Lista original: " + numeros);

		List<Integer> pares = numeros.stream()
								.filter(num -> num % 2 == 0)
								.collect(Collectors.toList());

		System.out.println("Números pares: " + pares);

	}

	public void ejercicio02() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

		System.out.println("Lista original: " + numeros);
		List<Integer> potenciados = numeros.stream()
										.map(num -> num * num)
										.collect(Collectors.toList());

		System.out.println("Elementos elevados al cuadrado: " + potenciados);

	}
	
	public void ejercicio03() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "Java", "Stream", "Lambda");

        System.out.println("Lista de cadenas: " + cadenas);      
        Map<String, Integer> conteoCaracteres = cadenas.stream()
                                                       .collect(Collectors.toMap(
                                                           cadena -> cadena,
                                                           cadena -> cadena.length()));

        System.out.println("Cantidad de caracteres por cadena: " + conteoCaracteres);
    }
		
	public void ejercicio04() {
		List<Integer> numeros = Arrays.asList(12, 522, 13, 454, 15, 66, 517, 218, 59, 110);

		System.out.println("Lista original: " + numeros);
		 Optional<Integer> maximo = numeros.stream()
                 						.max(Integer::compareTo);

		if (maximo.isPresent()) {
			System.out.println("Máximo valor: " + maximo.get());
		} else {
			System.out.println("La lista está vacía.");
		}
								
	}
	
	public void ejercicio05() {
		List<Integer> numeros = Arrays.asList(12, 522, 218, 59, 110);

		System.out.println("Lista original: " + numeros);
		Integer resultado = numeros.stream()
								.reduce(0, Integer::sum);

        System.out.println("Suma de todos los elementos: " + resultado);
	}
	
	public void ejercicio06() {
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("Lista original: " + numeros);

		 boolean todosMayoresACinco = numeros.stream()
                 						.allMatch(num -> num > 5);

		if (todosMayoresACinco) {
			System.out.println("Todos los elementos son mayores que 5.");
		} else {
			System.out.println("Al menos un elemento no es mayor que 5.");
		}

	}
	
	public void ejercicio07() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "Hola", "Java", "Mundo");

        System.out.println("Lista original: " + cadenas);
       
        //Creando una Coleccion de String
        List<String> sinDuplicados = 
        		cadenas.stream()
                           .distinct()
                           .collect(Collectors.toList());

        System.out.println("Lista sin duplicados: " + sinDuplicados);
        
        //Creando un Mapa
        Map<String, String> miMapa = cadenas.stream()
        	.distinct()
        	.collect(Collectors.toMap(
        			c-> c, //Key
        			c -> (c.length() + c) //Value
        		));
        for (Map.Entry<String, String> entry : miMapa.entrySet()) {
        	String key = entry.getKey();
        	String val = entry.getValue();
			
        	System.out.println("Mapa sin duplicados: Key: " + key + " Value: "+ val);
		}
	}
	
	public void ejercicio08() {
		List<Integer> numeros = Arrays.asList(16, 12, 32, 45, 15);

		System.out.println("Lista original: " + numeros);
		double promedio = numeros.stream()
				                .mapToDouble(Integer::doubleValue)
				                .average().orElse(0);

		System.out.println("El Promedio es: " + promedio);

	}
	
	public void ejercicio09() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "Hola", "Java", "Mundo");

        System.out.println("Lista original: " + cadenas);
       
        List<String> enMayusculas = cadenas.stream()
                                            //.map(cadena -> cadena.toUpperCase())
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());

        System.out.println("Lista en Mayusculas: " + enMayusculas);
	}
	
	public void ejercicio10() {
		List<String> cadena1 = Arrays.asList("Hola", "Mundo", "Hola", "Java", "Mundo");
		List<String> cadena2 = Arrays.asList("Hola", "Como", "estan", "Java", "Developers");
	
		 System.out.println("Lista 1: " + cadena1);
	     System.out.println("Lista 2: " + cadena2);

	       
	     Set<String> cadenas = Stream.concat(cadena1.stream(), cadena2.stream())
	                                     .distinct()
	                                     .collect(Collectors.toSet());

	     System.out.println("Lista combinada sin duplicados: " + cadenas);									
		
	}
	
	public void ejercicio11() {
		List<String> cadena = Arrays.asList("Alejandro", "Diego", "Alicia", 
										"Armando", "Cesar", "Martin");
		
		 System.out.println("Lista Original: " + cadena);
		 
		 //List<String> empiezanConA = 
				 cadena.stream()
                 				.filter(nombre -> nombre.startsWith("A"))
                 				.forEach(System.out::println);

		 //System.out.println("Nombres que empiezan con 'A': " + empiezanConA);
				 						
	}
	
	public void ejercicio12() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "Java", "Stream", "Lambda");

        System.out.println("Lista de cadenas: " + cadenas);      
        Map<String, Integer> conteoCaracteres = cadenas.stream()
                                                       .collect(Collectors.toMap(
                                                           cadena -> cadena,
                                                           cadena -> cadena.length()
                                                           )
                                                    	);

        System.out.println("Cantidad de caracteres por cadena: " + conteoCaracteres);
    }
	
	public void ejercicio13() {
		List<Integer> numeros = Arrays.asList(3, 5, 2, 9, 12);

		System.out.println("Lista original: " + numeros);
		Integer resultado = numeros.stream()
                				.reduce(1, (a, b) -> a * b);

        System.out.println("Producto de todos los elementos: " + resultado);
		
	}
	
	public void ejercicio14() {
		List<Integer> numeros = Arrays.asList(21, 28, 13, 49, 54, 64, 74, 86, 59, 150);

		System.out.println("Lista original: " + numeros);

		List<Integer> divisiblesPorSiete = numeros.stream()
								.filter(num -> num % 7 == 0)
								.collect(Collectors.toList());

		System.out.println("Números divisibles por 7: " + divisiblesPorSiete);

	}
	
	public void ejercicio15() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "Java", "Stream", "Lambda");

        System.out.println("Lista de cadenas: " + cadenas);      
        List<String> cadenaOrdenInverso = cadenas.stream()
							                .sorted(Comparator.reverseOrder())
							                .collect(Collectors.toList());

        System.out.println("Cadena en Orden Alfabetico Invertido: " + cadenaOrdenInverso);
    }
	
	public void ejercicio16() {
		List<String> cadenas = Arrays.asList("Hola", "Mundo", "si", "no", "Lambda", "Meta");

        System.out.println("Lista de cadenas: " + cadenas);      
        long cantidad = cadenas.stream()
				                .filter(cadena -> cadena.length() > 3)
				                .count();

        System.out.println("Cantidad de elementos con longitud mayor que 3: " 
        				+ cantidad + " Cadenas");
	}
	
	public void ejercicio17() {
		
		List<Integer> numeros = Arrays.asList( 2, 4, 5, 9);

		System.out.println("Lista original: " + numeros);

		
		int sumaCuadrados = numeros.stream()
								.filter(num -> num % 2 == 0)
				                .mapToInt(num -> num * num)
				                .sum();

		System.out.println("Suma de los Cuadrados de los Pares: " + sumaCuadrados);
		 
	}
	
	public void ejercicio18() {
		List<String> cadena = Arrays.asList("Hola", "Mundo", "Hola", "Java", "Mundo");
		 System.out.println("Lista original: " + cadena);
		
		 String concatenadas = cadena.stream()
                 				.collect(Collectors.joining());

		 System.out.println("Cadenas concatenadas con joining: " + concatenadas);
		 concatenadas = cadena.stream()
  								.reduce("", (a,b) -> a + b);

		 System.out.println("Cadenas concatenadas con reduce: " + concatenadas);
		
	}
	
	public void ejercicio19() {
		List<String> cadena1 = Arrays.asList("Hola", "Mundo", "Java", "Stream", "Lambda");
        List<String> cadena2 = Arrays.asList("Adios", "Cielo", "Python", "Flujo", "Kotlin");

        System.out.println("Cadena 1: " + cadena1);
        System.out.println("Cadena 2: " + cadena2);
       
        List<String> cadenasOrdenadas = Stream.concat(cadena1.stream(), cadena2.stream())
                                              .distinct()
                                              .sorted()
                                              .collect(Collectors.toList());

        System.out.println("Cadenas en Orden Alfabetico: " + cadenasOrdenadas);
		
	}
	
	public void ejercicio20() {
		List<Integer> numeros = Arrays.asList(3, 8, 12, 15, 18, 20, 25);

        System.out.println("Lista original: " + numeros);    
        /*
        Optional<Integer> primerDivisiblePor5 = numeros.stream()
                                                      .filter(num -> num % 5 == 0)
                                                      .findFirst();

        if (primerDivisiblePor5.isPresent()) {
            System.out.println("El primer número divisible por 5 es: " + primerDivisiblePor5.get());
        } else {
            System.out.println("No se encontró ningún número divisible por 5 en la lista.");
        }*/
        Integer primerDivisiblePor5 = numeros.stream()
						                .filter(num -> num % 5 == 0)
						                .findFirst().orElse(0);
        
        System.out.println("El primer número divisible por 5 es: " + primerDivisiblePor5);
	}
}

