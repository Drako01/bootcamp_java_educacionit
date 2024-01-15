package com.educacionitBD;

import java.sql.SQLException;

public class TestDBManager {

	public static void main(String[] args) throws SQLException {
		
		DBManager dbManager = new DBManager();

		dbManager.conectar();
		
		dbManager.verificarYCrearTabla();

		dbManager.mostrarAlumnos();

		Alumno alumno = new Alumno( 1, "Alejandro", 47, "Matematica");//
		dbManager.insertarAlumno(alumno);
		
		dbManager.mostrarAlumnos();
		
		alumno.setEdad(48);
		alumno.setEspecialidad("Sistemas");
		dbManager.modificarAlumno(alumno);
		
		dbManager.mostrarAlumnos();
		
		dbManager.eliminarAlumno(1);
		
		dbManager.mostrarAlumnos();

		dbManager.closeConnection();

	}

}
