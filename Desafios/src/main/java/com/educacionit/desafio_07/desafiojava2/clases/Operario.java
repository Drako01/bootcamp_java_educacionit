package com.educacionit.desafio_07.desafiojava2.clases;

import java.util.Scanner;

import com.educacionit.desafio_07.desafiojava2.excepcion.RespuestaInvalidaException;

public class Operario {
	private Scanner scanner;

	public Operario() {
		this.scanner = new Scanner(System.in);
	}

	public boolean confirmarAterrizaje(boolean tieneContrato) {
		return tieneContrato ? true : false;
	}

	public boolean confirmarAterrizajePistaDos() {
	    while (true) {
	        try {
	            System.out.println("OPERADOR: ¿Autorizar aterrizaje en la PISTA 2? (Sí/No):");
	            String respuesta = scanner.nextLine().toLowerCase(); 
	            if (respuesta.equals("si")) {
	                return true;
	            } else if (respuesta.equals("no")) {
	                return false;
	            } else {
	                throw new RespuestaInvalidaException("Error: Respuesta inválida. Por favor, responda 'Sí' o 'No'.");
	            }
	        } catch (RespuestaInvalidaException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}




}
