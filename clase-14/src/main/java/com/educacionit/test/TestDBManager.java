package com.educacionit.test;

import java.sql.SQLException;

import com.educacionit.DBManager;
import com.educacionit.IDBManager;
import com.educacionit.dao.model.Alumno;

public class TestDBManager {

	public static void main(String[] args) throws SQLException {
		try {

			IDBManager dbManager = new DBManager();

			dbManager.conectar();

			dbManager.mostrarAlumnos();

			Alumno alumno = new Alumno(3000, "Juana", 1, null);
			dbManager.insertarAlumno(alumno);
			dbManager.mostrarAlumnos();

			alumno.setEdad(40);
			alumno.setEspecialidad("Sistemas");
			dbManager.modificarAlumno(alumno);
			dbManager.mostrarAlumnos();
			dbManager.eliminarAlumno(alumno.getLegajo());
			dbManager.close();
			
		} catch (Exception exec) {
			exec.printStackTrace();
		}
	}

}
