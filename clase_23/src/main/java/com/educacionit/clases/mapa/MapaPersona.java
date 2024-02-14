package com.educacionit.clases.mapa;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.educacionit.clases.Persona;

public class MapaPersona {

	public static void main(String[] args) {
		
		HashMap<Integer, Persona> mapa = new HashMap<>();
		
		Persona p1 = new Persona("Alejandro", 47);
		Persona p2 = new Persona("Barbara", 41);
		
		mapa.put(p1.hashCode(), p1);
		mapa.put(p2.hashCode(), p2);
		
		Persona p3 = mapa.get(p1.hashCode());
		System.out.println(p3);
		System.out.println("Tamaño del Mapa: " + mapa.size());
		
		Set<Entry<Integer, Persona>> entrys = mapa.entrySet();
		for (Entry<Integer, Persona> entry : entrys) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}
		
	}
}
