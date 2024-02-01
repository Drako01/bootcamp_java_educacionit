package com.educacionit.generics;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Number> unaLista = new ArrayList<>();
		
		unaLista.add(Integer.valueOf(1));
		unaLista.add(Double.valueOf(1.2));
		unaLista.add(Byte.valueOf((byte)1));

		
		List<Alumno<String, Integer>> unaLista2 = new ArrayList<>();		
		
	}

}
