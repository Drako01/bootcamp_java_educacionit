package ejercicios_de_pruba_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ejercicios_de_pruba_maven.conexion.DBManager;
import ejercicios_de_pruba_maven.entidad.Alumno;
import ejercicios_de_pruba_maven.entidad.Curso;

@SpringBootApplication
@ComponentScan(basePackages = { "ejercicios_de_pruba_maven" })
public class MiPrmerApp {

	public static void main(String[] args) {

		DBManager controller = new DBManager();
		controller.getConnection();

		@SuppressWarnings("unused")
		ConfigurableApplicationContext context = SpringApplication.run(MiPrmerApp.class, args);

		Alumno alumno = new Alumno();
		
		// Creamos algunos alumnos
		/*
		for (int i = 1; i <= 10; i++) {
            
			alumno.setDni(1000000 + i);
			alumno.setNombre("Nombre" + i); 
			alumno.setApellido("Apellido" + i);  
			alumno.setLegajo(alumno.hashCode());
			controller.insertarAlumno(alumno);
        }*/

		
		controller.mostrarAlumnos();
		
		
	}

}
