package com.educacionit.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Uno");
		names.add("Dos");
		names.add("Tres");
		names.add("Cuatro");
		names.add("Dos");
		
		//Filter - forEach
		names.stream()
			.filter(name -> name.contains("r"))
			.forEach(name -> System.out.println(name));
		
		System.out.println("Usando Sorted");
		
		//Sorted
		names.stream()
			.sorted(Comparator.naturalOrder())
			.forEach(name -> System.out.println(name));
		
		//Combinar métodos
		List<String> namesNueva =
		names.stream()
			.filter(name -> name.contains("s"))
			.sorted(Comparator.naturalOrder())
			.collect(Collectors.toList());
		
		System.out.println(namesNueva);
		
		//Distinc
		names.stream()
			.distinct()
			.forEach(name -> System.out.println("Valores únicos: " + name));
		
		//Limit
		List<String> namesNuevaConLimit =
		names.stream()
			.limit(2)
			.collect(Collectors.toList());
		
		System.out.println("Lista usando Limit: " + namesNuevaConLimit);
		
		//Funciones terminales
	
		long cantidadDeElementos = 
		names.stream()
			.count();
			System.out.println("Tiene " + cantidadDeElementos + " elementos");
			
		long cantidadDeElementosFiltrados = 
		names.stream()
			.filter(name -> name.toLowerCase().contains("dos"))
			.count();
			System.out.println("Tiene " + cantidadDeElementosFiltrados + " elementos filtrados");
			

		//Reduce
		String concatenado =
		names.stream()
			.reduce("EstoVaAlPrincipioDel String - ", (a, b) -> a + b);
		System.out.println("Todo concatenado: " + concatenado);
		
		List<Integer> listaDeEnteros = new ArrayList<>();
		listaDeEnteros.add(1);
		listaDeEnteros.add(2);
		listaDeEnteros.add(3);
		
		Integer nuevaListaDeEnteros = 
				listaDeEnteros.stream()
					.reduce(100, (a, b) -> a - b); //El 100 lo suma
		System.out.println("Reduce Enteros: " + nuevaListaDeEnteros);
		
		
	}

}
