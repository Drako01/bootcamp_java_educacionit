package com.educacionit.dao.main;

import java.util.Date;

import com.educacionit.dao.model.Alumno;
import com.educacionit.dao.model.Curso;
import com.educacionit.dao.model.Especialidad;
import com.educacionit.dao.model.Profesor;
import com.educacionit.dao.service.AlumnoProfesoreCursoService;
import com.educacionit.dao.service.impl.AlumnoProfesoreCursoServiceImpl;

public class MainDAO {

	private static final Integer ID_CURSO = 3;

	public static void main(String[] args) {

		AlumnoProfesoreCursoService service = new AlumnoProfesoreCursoServiceImpl();

		// ----------------------
		// Funcionalidad de negocio
		// ----------------------

		// Punto 3.A - Permitir inscribir a un curso a un alumno nuevo.
		Alumno alumnoNuevo = new Alumno("Nombre", "Apellido", 40, "Direccion", new Date(), new Especialidad(1, null));
		service.inscribirAlumnoNuevoACurso(alumnoNuevo, ID_CURSO);

		// ------------------------------------------------------
		// Punto 3.B - Permitir inscribir a un nuevo profesor en un nuevo curso
		Profesor profesorNuevo = new Profesor("NombrePRofesor", "ApellidoProfesor", new Date());
		Curso cursoNuevo = new Curso("NombreCursoNuevo", "DescripcionCursoNuevo");
		service.inscribirNuevoProfesorANuevoCurso(profesorNuevo, cursoNuevo);

		// Punto 3.C
		Especialidad especialidadNueva = new Especialidad("Nombre de la nueva Especialidad");
		service.modificarAlumnoConNuevaEspecialidad(alumnoNuevo, especialidadNueva);
	}

}
