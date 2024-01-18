package com.educacionit.polimorfismo;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//ArrayList<MedioTransporte> array = new ArrayList<MedioTransporte>();
		ArrayList<IDesplazamiento> array = new ArrayList<IDesplazamiento>();
		Auto unAuto = new Auto();
		Colectivo unColectivo = new Colectivo();
		Taxi unTaxi = new Taxi();
		Patineta unaPatineta = new Patineta();
		
		array.add(unAuto);
		array.add(unColectivo);
		array.add(unTaxi);
		array.add(unaPatineta);
		
		for (int i = 0; i < array.size(); i++) {
			/*MedioTransporte medioDeTransporte = array.get(i);
			medioDeTransporte.despazarse();
			medioDeTransporte.getNombre();
			medioDeTransporte.setNombre(null);*/
			IDesplazamiento unDesplazamiento = array.get(i);
			unDesplazamiento.despazarse(); //Polimorfismo
			
			if(unDesplazamiento instanceof Auto) {
				Auto miAuto = (Auto)unDesplazamiento;
				miAuto.getNombre();
				miAuto.setNombre("Mi Auto");
				miAuto.unMetodoDeLaClaseAuto();
			} else if(unDesplazamiento instanceof Auto) {
				Colectivo miColectivo = (Colectivo)unDesplazamiento;
				miColectivo.getNombre();
				miColectivo.setNombre("Mi Colectivo");
			}else if(unDesplazamiento instanceof Taxi) {
				Taxi miTaxi = (Taxi)unDesplazamiento;
				miTaxi.getNombre();
				miTaxi.setNombre("Mi Taxi");
			}else if(unDesplazamiento instanceof Patineta) {
				Patineta miPatineta = (Patineta)unDesplazamiento;
				miPatineta.unMetodoDePatineta();
			}
		}
	}

}
