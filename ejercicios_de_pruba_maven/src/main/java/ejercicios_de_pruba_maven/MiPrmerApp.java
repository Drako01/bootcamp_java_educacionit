package ejercicios_de_pruba_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ejercicios_de_pruba_maven.conexion.DBManager;

@SuppressWarnings("unused")
@SpringBootApplication
@ComponentScan(basePackages = { "ejercicios_de_pruba_maven" })

public class MiPrmerApp {

	public static void main(String[] args) {

		DBManager controller = new DBManager();
		controller.getConnection();
		
		ConfigurableApplicationContext context = SpringApplication.run(MiPrmerApp.class, args);
		controller.closeConnection();
	}

}
