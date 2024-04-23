package com.educacionit.dao.test;

import java.util.ArrayList;

import com.educacionit.dao.AlumnoDAO;
import com.educacionit.dao.AlumnoDAOImpl;
import com.educacionit.dao.model.Alumno;

public class MainDaoTest {

	public static void main(String[] args) {

		AlumnoDAO alumnoDao = new AlumnoDAOImpl();

		try {	
			
			Alumno unAlumno = alumnoDao.obtenerUno(1000);
			ArrayList<Alumno> listaAlumnos = alumnoDao.obtenerTodos();
			
			Alumno alumnoDePrueba = new Alumno(3000, "Nombre de Alumno");
			alumnoDao.insertar(alumnoDePrueba);

			alumnoDePrueba.setEdad(40);
			alumnoDao.modificar(alumnoDePrueba);
			
			alumnoDao.eliminar(alumnoDePrueba.getLegajo());
			
			

		} catch (Exception exe) {
			System.out.println(exe.getMessage());
		}

	}

}
