package com.educacionit.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Ejercicios {

	public void ejercicio01() { 
		Set<String> setDias = Arrays.stream(DiasSemana.values())
				.map(nombre -> nombre.name())
				.map(nombre -> nombre.toLowerCase())
				.collect(Collectors.toSet());
	  
		System.out.println(setDias);
	 
	  }

	public void ejercicio02() {
		List<DiasSemana> diasQueEmpiezanConM = Arrays.stream(DiasSemana.values())
						.filter(dia -> dia.name()
						.startsWith("M"))
						.collect(Collectors.toList());

		System.out.println(diasQueEmpiezanConM);
	}
	
	public void ejercicio03() {
		
		Map<String, Integer> miMapa = Arrays.stream(DiasSemana.values())
				.collect(Collectors.toMap(
						key->key.name(), 
						value->value.name().length()
						)
						
				);
		System.out.println(miMapa);
	}
	
	public void ejercicio04() {
		
		double promedio = Arrays.stream(DiasSemana.values())
				.mapToInt(diasSemana -> diasSemana.name().length())
				.average().orElse(0);
		
		System.out.println(promedio);
	}
	
	public void ejercicio05() {
		
		Set<String> setDias = Arrays.stream(DiasSemana.values())
				.map(nombre -> nombre.name())
				.collect(Collectors.toSet());
	  
		System.out.println(setDias);
	}
	
	public void ejercicio06() {
		Set<DiasSemana> setDiasOrdenadoInverso = Arrays.stream(DiasSemana.values())
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toSet());
		
		
		System.out.println("Ejercicio 06: " + setDiasOrdenadoInverso);
	}
	
	public void ejercicio07() {
		int max = 7;
		int min = 6;
		
		List<DiasSemana> diasConSeisOSiete = 
				Arrays.stream(DiasSemana.values())
				.filter(
						dia -> {
						if(dia.name().length() >= min && dia.name().length() <= max ){
							return true;
						}
						return false;
						})
					.collect(Collectors.toList());
				
				
		System.out.println("Ejercicio 07: " + diasConSeisOSiete);
			
	}
}
