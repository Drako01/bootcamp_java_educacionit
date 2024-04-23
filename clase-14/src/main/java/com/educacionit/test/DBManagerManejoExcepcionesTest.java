package com.educacionit.test;

import java.io.IOException;
import java.util.ArrayList;

import com.educacionit.DBManager;
import com.educacionit.dao.model.Alumno;
import com.educacionit.exception.DBManagerException;
import com.educacionit.exception.DBManagerObtenerAlumnoException;

public class DBManagerManejoExcepcionesTest {

	public static void main(String[] args)  {

		ArrayList<Alumno> alumnos = null;
		
		try (DBManager dbManager = new DBManager();)
		{
			
			dbManager.conectar();
			
			dbManager.obtenerAlumno(-1);
			
			alumnos = dbManager.obtenerAlumnos();
			
		} catch (DBManagerObtenerAlumnoException exec) {
			System.out.println("No fue posible encontrar al alumno. Err: " + exec.getMessage());
			if (exec.getErroCode() == 1) {
				System.out.println("Se produjo el error 1");
			}
		} catch (DBManagerException exec) {
			System.out.println("Se produjo un error: " + exec.getMessage());
		} catch (IOException exec) {
			System.out.println("Se produjo un error: " + exec.getMessage());
		}

		System.out.println("Fin Main");
		
	}

}
