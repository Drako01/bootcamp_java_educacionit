package com.educacionit.desafio_07.desafiojava2.clases;

import com.educacionit.desafio_07.desafiojava2.interfaces.AterrizajeInterface;
import com.educacionit.desafio_07.desafiojava2.interfaces.ContratoAterrizaje;
import com.educacionit.desafio_07.desafiojava2.interfaces.VoladorInterface;

public class Avion implements VoladorInterface, AterrizajeInterface, ContratoAterrizaje {
	private boolean autorizacionOperador;
	private String nombre;

	public Avion(boolean autorizacionOperador, String nombre) {
		this.autorizacionOperador = autorizacionOperador;
		this.nombre = nombre;
	}

	@Override
	public void volar() {
		System.out.println("El vuelo: " + this.nombre + " está solicitado Autorización para Aterrizaje.");
	}

	@Override
	public void aterrizar() {
		System.out.println("El vuelo: " + this.nombre + " está Aterrizando.!.");
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean puedeAterrizar() {
		return autorizacionOperador;
	}

	@Override
	public boolean tieneContrato() {
		return this.autorizacionOperador;
	}
}
