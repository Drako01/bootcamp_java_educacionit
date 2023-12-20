package com.educacionit.statics;

public class VariablesClase {
	
	private static int miVariableDeClase;
	private String nombre;

	public VariablesClase(String nombre) {
		super();
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getCuantasInstanciasEnMemoria() {
		return miVariableDeClase;
	}

	@Override
	protected void finalize() throws Throwable {		
		miVariableDeClase--;
		System.out.println("FINALIZE");
	}

	
	
}
