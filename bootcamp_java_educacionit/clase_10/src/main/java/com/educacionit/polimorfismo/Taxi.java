package com.educacionit.polimorfismo;

public class Taxi extends MedioTransporte {
	
	@Override
	public void despazarse() {
		System.out.println("Soy Taxi y me desplazo");
	}
}
