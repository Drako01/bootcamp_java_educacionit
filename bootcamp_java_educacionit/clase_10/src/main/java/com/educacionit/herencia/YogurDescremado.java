package com.educacionit.herencia;

public class YogurDescremado extends Yogur {
	public YogurDescremado() {
		super();		
	}
	
	// Reescritura
	@Override
	public float consultarCalorias() {
		return super.consultarCalorias()/ 2;
	}

}
