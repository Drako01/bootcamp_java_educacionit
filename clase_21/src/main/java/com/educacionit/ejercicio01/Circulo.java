package com.educacionit.ejercicio01;

public class Circulo implements Forma{
	
	private Double radio;
	

	public Circulo(Double radio) {
		super();
		this.radio = radio;
	}

	@Override
	public Double calcularArea() {		
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public Double calcularPerimetro() {		
		return 2 * Math.PI * radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + "]";
	}

}
