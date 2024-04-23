package com.educacionit.enums;

public class EmunSobrecargadoMain {

	public static void main(String[] args) {
		
		recibeUnaConstante(DiasSemanaSobrecargado.LUNES);
		recibeUnaConstante(DiasSemanaSobrecargado.MARTES);
		recibeUnaConstante(DiasSemanaSobrecargado.MIERCOLES);
		recibeUnaConstante(DiasSemanaSobrecargado.JUEVES);
		recibeUnaConstante(DiasSemanaSobrecargado.VIERNES);
		recibeUnaConstante(DiasSemanaSobrecargado.SABADO);
		recibeUnaConstante(DiasSemanaSobrecargado.DOMINGO);
		DiasSemanaSobrecargado[] values = DiasSemanaSobrecargado.values();
		
		for (DiasSemanaSobrecargado diasSemana : values) {
			System.out.println("Día: " + diasSemana);
		}
		
		
	}
	
	private static void recibeUnaConstante(DiasSemanaSobrecargado unEnum) {
		System.out.println("Nombre del Enum: " + unEnum.name());
		System.out.println("Nombre del Enum: " + unEnum.ordinal());
		System.out.println("Nombre del Enum: " + unEnum.toString());
	}

}
