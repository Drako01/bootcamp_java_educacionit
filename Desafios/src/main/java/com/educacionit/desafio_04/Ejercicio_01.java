package com.educacionit.desafio_04;

import java.util.Scanner;

class Usuario {
    private String usuarioCorrecto;
    private String contrasenaCorrecta;

    public Usuario(String usuarioCorrecto, String contrasenaCorrecta) {
        this.usuarioCorrecto = usuarioCorrecto;
        this.contrasenaCorrecta = contrasenaCorrecta;
    }
    /*
	 * Aca Utilizo el método equals para que compare exactamente el texto ingresado
	 * por el usuario con el que esta guardado en la variable. Aca es importante que
	 * el usuario respete las mayusculas y las minusculas.
	 */
    public boolean autenticar(String usuario, String contrasena) {
        return usuarioCorrecto.equals(usuario) && contrasenaCorrecta.equals(contrasena);
    }
}

public class Ejercicio_01 {

	public static void main(String[] args) {
		/*
		 * Crear un programa que simule un inicio de sesion con 2 cadenas de caracteres
		 * (usuario y contraseña) Luego mostrar dos tipos de mensajes en pantalla:
		 * "Bienvenido al Sistema" o "Credenciales Incorrectas" en caso de que el
		 * ingreso sea incorrecto
		 */
		Usuario usuario = new Usuario("Usuario", "Contrasenia");
		
		Scanner scanner = new Scanner(System.in);

		System.out.print("Ingrese su usuario: ");
		String usuarioIngresado = scanner.nextLine();

		System.out.print("Ingrese su contraseña: ");
		String contrasenaIngresada = scanner.nextLine();
		
		if (usuario.autenticar(usuarioIngresado, contrasenaIngresada)) {
            System.out.println("Bienvenido al Sistema");
        } else {
            System.out.println("Credenciales Incorrectas");
        }

		scanner.close();

	}

}
