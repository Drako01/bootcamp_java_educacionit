package com.educacionit.polimorfismo;

public class Patineta implements IDesplazamiento {
	
	@Override
	public void despazarse() {
		System.out.println("Soy una Patineta y me desplazo");
	}
	
	public void unMetodoDePatineta() {	
		System.out.println("Hago divertir a los Chicos");
	};
	
}
