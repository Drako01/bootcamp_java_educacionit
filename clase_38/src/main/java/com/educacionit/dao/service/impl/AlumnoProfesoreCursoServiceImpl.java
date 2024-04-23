package com.educacionit.dao.service.impl;

import java.util.List;

import com.educacionit.dao.AlumnoDAO;
import com.educacionit.dao.CursoDAO;
import com.educacionit.dao.EspecialidadDAO;
import com.educacionit.dao.InscripcionAlumnoCursoDAO;
import com.educacionit.dao.InscripcionProfesorCursoDAO;
import com.educacionit.dao.ProfesorDAO;
import com.educacionit.dao.impl.AlumnoDAOImpl;
import com.educacionit.dao.impl.CursoDAOImpl;
import com.educacionit.dao.impl.EspecialidadDAOImpl;
import com.educacionit.dao.impl.InscripcionAlumnoCursoDAOImpl;
import com.educacionit.dao.impl.InscripcionProfesorCursoDAOImpl;
import com.educacionit.dao.impl.ProfesorDAOImpl;
import com.educacionit.dao.model.Alumno;
import com.educacionit.dao.model.Curso;
import com.educacionit.dao.model.Especialidad;
import com.educacionit.dao.model.InscripcionAlumnoCurso;
import com.educacionit.dao.model.Profesor;
import com.educacionit.dao.service.AlumnoProfesoreCursoService;

public class AlumnoProfesoreCursoServiceImpl implements AlumnoProfesoreCursoService {

	private AlumnoDAO alumnoDAO = new AlumnoDAOImpl();
	private ProfesorDAO profesorDAO = new ProfesorDAOImpl();
	private CursoDAO cursoDAO = new CursoDAOImpl();
	private InscripcionProfesorCursoDAO inscripcionProfesorCursoDAO = new InscripcionProfesorCursoDAOImpl();
	private EspecialidadDAO especialidadDAO = new EspecialidadDAOImpl();
	private InscripcionAlumnoCursoDAO inscripcionAlumnoCursoDAO = new InscripcionAlumnoCursoDAOImpl();

	@Override
	public void inscribirAlumnoNuevoACurso(Alumno alumnoNuevo, Integer idCurso) {

		// Doy de alta al nuevo alumno
		Integer idAltaAlumno = alumnoDAO.alta(alumnoNuevo);

		// Inscribo al alumno dado de alta a un curso
		inscripcionAlumnoCursoDAO.alta(alumnoNuevo, idCurso);

	}

	@Override
	public void inscribirNuevoProfesorANuevoCurso(Profesor nuevoProfesor, Curso nuevoCurso) {

		// 1.- Alta Profesor
		Integer idProfesor = profesorDAO.alta(nuevoProfesor);
		nuevoProfesor.setId(idProfesor); // Actualizo Profesor con el nuevo id de DB

		// 2.- Alta Curso
		Integer idCurso = cursoDAO.alta(nuevoCurso);
		nuevoCurso.setId(idCurso); // Actualizo Curso con el nuevo id de DB

		// 3.- Asignar Curso a un Profesor
		inscripcionProfesorCursoDAO.alta(nuevoProfesor.getId(), nuevoCurso.getId());
	}

	@Override
	public void modificarAlumnoConNuevaEspecialidad(Alumno alumno, Especialidad especialidad) {
		// 1.- Dar de alta la nueva especialidad.
		Integer idEspecialidad = especialidadDAO.alta(especialidad);
		especialidad.setId(idEspecialidad);

		// 2.- Modificar el alumno.
		alumno.setEspecialidad(especialidad);
		alumnoDAO.modificacion(alumno);
	}

	@Override
	public List<InscripcionAlumnoCurso> obtenerCursosDeAlumno(Integer idAlumno) {
		return inscripcionAlumnoCursoDAO.buscarPorAlumno(idAlumno);
	}

	/*
	 * public void altaEspecialidad(Especialidad especialidad ) { EspecialidadDAO
	 * especialidadDAO = new EspecialidadDAOImpl();
	 * especialidadDAO.alta(especialidad); }
	 */

}
