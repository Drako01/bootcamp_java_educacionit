package com.educacionit;

import java.util.List;

public class Api {
	
	public Integer suma(Integer a, Integer b) {
		if (a == null) {
			return -1;
		}
		if (b == null) {
			return null;
		}
		return a+b;
	}
	
	public Boolean contiene( List<Integer> collection, Integer a) {
		if (collection == null ) {
			return null;
		}
		return collection.contains(a);
	}
	
	public String concat(String a, String b) {
		if (b == null ) {
			throw new IllegalArgumentException("El segundo parametro no puede ser null");
		}
		return a+b;
	}
	
	
	public List<Integer> agregarElemento(List<Integer> lista, Integer a) {
		lista.add(a);
		return lista;
	}

}
