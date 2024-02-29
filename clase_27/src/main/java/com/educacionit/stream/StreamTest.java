package com.educacionit.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Uno");
		names.add("Dos");
		names.add("Tres");
		names.add("Cuatro");
		
		names.stream()
			.filter(name -> name.contains("s"))
			.forEach(name -> System.out.println(name));
		
	}

}
