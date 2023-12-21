package com.educacionit.polimorfismo;

// Con final se corta la Herencia
public final class Auto extends MedioTransporte {
	@Override
	public void despazarse() {
		System.out.println("Soy Auto y me desplazo");
	}
	
}
