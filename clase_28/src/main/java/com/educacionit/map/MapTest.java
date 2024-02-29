package com.educacionit.map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapTest {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		Person p1 = new Person(1, "Alejandro");
		Person p2 = new Person(1, "Daniel");

		persons.add(p1);
		persons.add(p2);

		
		List<Persona> personas = 
		persons.stream()
			.map(person -> {
				Persona unaPersona = new Persona();
				unaPersona.setId(person.getId());
				unaPersona.setName(person.getName());
				return unaPersona;
			}
			).collect(Collectors.toList());

		System.out.println(personas);
	}

}
