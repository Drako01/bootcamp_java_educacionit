package com.educacionit.desafio_07.desafiojava2.clases;

import java.util.ArrayList;
import java.util.List;

import com.educacionit.desafio_07.desafiojava2.excepcion.RespuestaInvalidaException;
import com.educacionit.desafio_07.desafiojava2.interfaces.ContratoAterrizaje;

public class TorreControl {
	private List<Avion> aviones;
	private Operario operario;

	public TorreControl() {
		this.aviones = new ArrayList<>();
		this.operario = new Operario();
	}

	public void agregarAvion(Avion avion) {
		aviones.add(avion);
	}

	public void gestionarAterrizaje() throws RespuestaInvalidaException {
		for (Avion avion : aviones) {
			if (avion instanceof ContratoAterrizaje && avion.tieneContrato()) {
				avion.volar();
				System.out.println("El vuelo de: " + avion.getNombre() + " tiene un contrato correcto.\n"
						+ "El operario confirma el aterrizaje en la PISTA 1.\n"
						+ "Aterrizaje en la PISTA 1 permitido para " + avion.getNombre());
				avion.aterrizar();
				System.out.println("\n");
			} else {
				avion.volar();
				System.out.println("El Contrato del vuelo: " + avion.getNombre() +
						" no cumple las Condiciones para Autorizar el Aterrizaje. \n"
						+ "Debe Solicitar Autorización al Operador");
				if (operario.confirmarAterrizajePistaDos()) {
					System.out.println("El operario confirma el aterrizaje en la PISTA 2.\n"
							+ "Aterrizaje en la PISTA 2 permitido para el vuelo de: " + avion.getNombre());
					avion.aterrizar();
					System.out.println("\n");
				} else {
					System.out.println("No es posible aterrizar el vuelo de: " + avion.getNombre() + " en la pista 2!\n"
							+ "El operario No Autoriza el aterrizaje!\n" + avion.getNombre() + " | Rediríjase a otro Aeropuerto.!\n");
				}
			}

		}
		System.out.println("No hay más vuelos para autorizar.");
	}
}