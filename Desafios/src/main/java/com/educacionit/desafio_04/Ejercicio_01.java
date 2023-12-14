package com.educacionit.desafio_04;

import java.util.Scanner;

public class Ejercicio_01 {

	public static void main(String[] args) {
		/*
		 * Crear un programa que simule un inicio de sesion con 2 cadenas de caracteres
		 * (usuario y contraseña) Luego mostrar dos tipos de mensajes en pantalla:
		 * "Bienvenido al Sistema" o "Credenciales Incorrectas" en caso de que el
		 * ingreso sea incorrecto
		 */
		
		String usuarioCorrecto = "usuario";
		String contrasenaCorrecta = "contrasenia";
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese su usuario: ");
		String usuarioIngresado = scanner.nextLine();

		System.out.print("Ingrese su contraseña: ");
		String contrasenaIngresada = scanner.nextLine();
		
		if (usuarioCorrecto.equals(usuarioIngresado) && contrasenaCorrecta.equals(contrasenaIngresada)) {
			System.out.println("Bienvenido al Sistema");
		} else {
			System.out.println("Credenciales Incorrectas");
		}

		scanner.close();

	}

}
