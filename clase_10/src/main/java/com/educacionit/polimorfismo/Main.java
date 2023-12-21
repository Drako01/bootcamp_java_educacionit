package com.educacionit.polimorfismo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<MedioTransporte> array = new ArrayList<MedioTransporte>();
		
		Auto unAuto = new Auto();
		Colectivo unColectivo = new Colectivo();
		Taxi unTaxi = new Taxi();
		
		array.add(unAuto);
		array.add(unColectivo);
		array.add(unTaxi);
		
		for (int i = 0; i < array.size(); i++) {
			MedioTransporte medioDeTransporte = array.get(i);
			medioDeTransporte.despazarse();
			medioDeTransporte.getNombre();
			medioDeTransporte.setNombre(null);
		}
	}

}
