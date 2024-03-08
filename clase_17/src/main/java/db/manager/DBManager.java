package db.manager;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.excepciones.DBConexionException;
import db.excepciones.DBManagerException;

public class DBManager implements Closeable{

	private static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private Connection conn;

	public void conectar() throws DBManagerException {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Conexión exitosa a la base de datos");
		} catch (SQLException e) {
			throw new DBManagerException(DBConexionException.ERROR_1,
					"Error al conectar a la base de datos: " + e.getMessage(), e);
		} finally {
			System.out.println("Fin Bloque de Conexión a la base de datos");
		}
	}

	public void verificarYCrearTabla() throws DBManagerException {
		String table = "alumnos";
		try (Statement statement = conn.createStatement()) {
			String query = "CREATE TABLE IF NOT EXISTS " + table 
							+ " (" + "legajo INT PRIMARY KEY,"
							+ "nombre VARCHAR(255) NOT NULL," 
							+ "edad INT NOT NULL," 
							+ "especialidad VARCHAR(255) NOT NULL)";
			statement.executeUpdate(query);
			System.out.println("Tabla " + table + " verificada y creada si no existía");
		} catch (SQLException e) {
			throw new DBManagerException(DBConexionException.ERROR_3,
					"Error al verificar y crear la tabla: " + e.getMessage(), e);
		}finally {
			System.out.println("Fin Bloque de Verificación de la Tabla " + table 
					+ " en la base de datos");
		}
	}

	public void mostrarAlumnos() throws DBManagerException {
		String query = "SELECT legajo, nombre, edad, especialidad FROM alumnos";
		try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				int legajo = resultSet.getInt("legajo");
				String nombre = resultSet.getString("nombre");
				int edad = resultSet.getInt("edad");
				String especialidad = resultSet.getString("especialidad");
				System.out.println("Legajo: " + legajo + ", Nombre: " + nombre + ", Edad: " + edad + ", Especialidad: "
						+ especialidad);
			}
		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_1, "Error al mostrar alumnos: " + e.getMessage(), e);
		}
	}

	public void insertarAlumno(Alumno alumno) throws DBManagerException {
		String query = "INSERT INTO alumnos (legajo, nombre, edad, especialidad) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, alumno.getLegajo());
			statement.setString(2, alumno.getNombre());
			statement.setInt(3, alumno.getEdad());
			statement.setString(4, alumno.getEspecialidad());

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) throw new DBManagerException(
				DBManagerException.ERROR_6, "No se pudo insertar el alumno: " + alumno);
			else System.out.println("El Alumno " + alumno + " modificado correctamente");

		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_6, "Error al insertar alumno: " + e.getMessage(), e);
		}
	}

	public ArrayList<Alumno> mostrarLosAlumnos() throws DBManagerException {
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

		String query = "SELECT legajo, nombre, edad, especialidad FROM alumnos";
		
		try (
				Statement statement = conn.createStatement(); 
				ResultSet resultSet = statement.executeQuery(query);
			) {

			while (resultSet.next()) {
				int legajo = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				int edad = resultSet.getInt(3);
				String especialidad = resultSet.getString(4);

				Alumno unAlumno = new Alumno(legajo, nombre);
				unAlumno.setEdad(edad);
				unAlumno.setEspecialidad(especialidad);

				listaAlumnos.add(unAlumno);

			}

		} catch (SQLException e) {
			throw new DBManagerException(DBManagerException.ERROR_2, 
					"Error al mostrar alumnos: " + e.getMessage(), e);
		} 
		return listaAlumnos;
	}

	public Alumno obtenerUnAlumno(Integer legajo) throws DBManagerException {

		String query = "SELECT nombre, edad, especialidad FROM alumnos WHERE legajo = ?";
		
		ResultSet resultSet = null;
		try (PreparedStatement statement = conn.prepareStatement(query);)
			{
			
			statement.setInt(1, legajo);

			resultSet = statement.executeQuery();

			Boolean hayRegistros = resultSet.next();

			if (hayRegistros == false) {
				throw new DBManagerException(DBManagerException.ERROR_5,
						"No Existe ese Nro de legajo: " + legajo);
			}

			String nombre = resultSet.getString("nombre");
			Integer edad = resultSet.getInt(2);
			String especialidad = resultSet.getString(3);

			Alumno unAlumno = new Alumno(legajo, nombre);

			unAlumno.setEdad(edad);
			unAlumno.setEspecialidad(especialidad);

			return unAlumno;

		} catch (SQLException e) {

			throw new DBManagerException(DBManagerException.ERROR_4,
					"Error al mostrar el alumno de legajo: " + legajo + " por el Error: " + e.getMessage(), e);

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el resultSet" + e.getMessage());
			}			
		}

	}

	public void modificarAlumno(Alumno alumno) throws DBManagerException {
		String query = "UPDATE alumnos SET nombre = ?, edad = ?, especialidad = ? WHERE legajo = ?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setString(1, alumno.getNombre());
			statement.setInt(2, alumno.getEdad());
			statement.setString(3, alumno.getEspecialidad());
			statement.setInt(4, alumno.getLegajo());

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				throw new DBManagerException(
					DBManagerException.ERROR_7, "No se pudo modificar el alumno: " + alumno);
			}
			System.out.println("El Alumno " + alumno + " modificado correctamente");
		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_7, "Error al modificar alumno: " + e.getMessage(), e);
		}
	}

	public void eliminarAlumno(Integer legajo) throws DBManagerException {
		String query = "DELETE FROM alumnos WHERE legajo = ?";
		try (PreparedStatement statement = conn.prepareStatement(query)) {
			statement.setInt(1, legajo);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) System.err.println("No se pudo eliminar el alumno con Legajo: " + legajo);
			else System.out.println("El Alumno con Legajo: " + legajo
						+ " ha sido eliminado correctamente");				

		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_8, "Error al eliminar alumno: " + e.getMessage(), e);
		}
	}

	private void closeConnection() throws DBManagerException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("Conexión cerrada");
			}
		} catch (SQLException e) {
			throw new DBManagerException(
				DBConexionException.ERROR_4, "Error al cerrar la conexión: " + e.getMessage(), e);
		} finally {
			System.out.println("Bloque de Cerrar conexión Finalizado");
		}
	}

	@Override
	public void close() throws IOException {
		try {			
			closeConnection();
		} catch (DBManagerException e){
			throw new IOException(e);			
		}
		
	}
}
