package ejercicios_de_pruba_maven;

import ejercicios_de_pruba_maven.conexion.DBManager;
import ejercicios_de_pruba_maven.entidad.Alumno;
import ejercicios_de_pruba_maven.entidad.Curso;

public class MainTest {

	public static void main(String[] args) {

		DBManager controller = new DBManager();
		controller.getConnection();
		
		
		// Creamos algunos cursos
		Curso curso1 = new Curso();
		curso1.setTitulo("Curso de Java");
		curso1.setDescripcion("Aprende Java desde cero");

		Curso curso2 = new Curso();
		curso2.setTitulo("Curso de Spring Boot");
		curso2.setDescripcion("Desarrollo de aplicaciones web con Spring Boot");

		controller.insertarCurso(curso1);
		controller.insertarCurso(curso2);
		
		Alumno alumno = new Alumno();

		// Creamos algunos alumnos
		for (int i = 1; i <= 20; i++) {

			alumno.setDni(1000000 + i);
			alumno.setNombre("Nombre" + i);
			alumno.setApellido("Apellido" + i);
			alumno.setLegajo(alumno.hashCode());
			alumno.setIdCurso(1); 
			controller.insertarAlumno(alumno);
		}

		controller.mostrarAlumnos();

		controller.eliminarAlumno(1000005);

		controller.mostrarAlumnoPorDNI(1000005);

		alumno.setDni(1000032);
		alumno.setNombre("Alejandro");
		alumno.setApellido("Di Stefano");		
		alumno.setLegajo(alumno.hashCode());
		alumno.setIdCurso(2);
		controller.insertarAlumno(alumno);

		controller.modificarAlumno(1000006, "NuevoNombre", "NuevoApellido", 3);
		controller.mostrarAlumnoPorDNI(1000006);
		
		controller.closeConnection();

	}

}
