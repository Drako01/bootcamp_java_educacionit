package com.educacionit.dbmanager;

import java.util.ArrayList;

import com.educacionit.excepciones.DBManagerException;

public class TestDBManagerNew {

	public static void main(String[] args) {

		DBManager dbManager = new DBManager();

		try {
			dbManager.conectar();

			dbManager.mostrarAlumnos();

			dbManager.obtenerUnAlumno(2);

			ArrayList<Alumno> alumnos = dbManager.mostrarLosAlumnos();

			for (int i = 0; i < alumnos.size(); i++) {
				Alumno unAlumno = alumnos.get(i);
				System.out.println("Alumno: " + unAlumno);
			}

		} catch (DBManagerException e) {

			System.err.println("Se produjo un Error: " + e.getMessage());
		}
	}

}
