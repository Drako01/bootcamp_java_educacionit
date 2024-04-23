package ejercicios_de_pruba_maven;

import ejercicios_de_pruba_maven.conexion.DBManager;

public class MainDropTables {

	public static void main(String[] args) {
		DBManager controller = new DBManager();
		controller.getConnection();
		
		controller.eliminarTabla("alumnos");
		controller.eliminarTabla("cursos");
		
		controller.closeConnection();
	}

}
