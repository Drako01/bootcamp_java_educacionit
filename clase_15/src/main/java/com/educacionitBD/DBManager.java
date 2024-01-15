package com.educacionitBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private Connection conn;

	public void conectar() throws SQLException {

		conn = DriverManager.getConnection(URL, USER, PASSWORD);
		if (conn != null) {
			System.out.println("Conexión exitosa a la base de datos");
		}

	}

	public void verificarYCrearTabla() throws SQLException {
		Statement statement = conn.createStatement();
		String query = "CREATE TABLE IF NOT EXISTS Alumnos (" + "legajo INT PRIMARY KEY,"
				+ "nombre VARCHAR(255) NOT NULL," + "edad INT NOT NULL," + "especialidad VARCHAR(255) NOT NULL)";
		statement.executeUpdate(query);
		System.out.println("Tabla 'Alumnos' verificada y creada si no existía");

	}

	public void mostrarAlumnos() throws SQLException {

		String query = "SELECT legajo, nombre, edad, especialidad FROM alumnos";
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			int legajo = resultSet.getInt("legajo");
			String nombre = resultSet.getString("nombre");
			int edad = resultSet.getInt("edad");
			String especialidad = resultSet.getString("especialidad");

			System.out.println("Legajo: " + legajo + ", Nombre: " + nombre + ", Edad: " + edad + ", Especialidad: "
					+ especialidad);
		}
		resultSet.close();
		statement.close();
	}

	public void insertarAlumno(Alumno alumno) throws SQLException {
		String query = "INSERT INTO alumnos (legajo, nombre, edad, especialidad) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, alumno.getLegajo());
		statement.setString(2, alumno.getNombre());
		statement.setInt(3, alumno.getEdad());
		statement.setString(4, alumno.getEspecialidad());

		int rowsAffected = statement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("El Alumno " + alumno + "fue insertado correctamente");
		} else {
			System.out.println("No se pudo insertar el alumno: " + alumno);
		}
		statement.close();
	}

	public void modificarAlumno(Alumno alumno) throws SQLException {

		String query = "UPDATE Alumnos SET nombre = ?, edad = ?, especialidad = ?  WHERE legajo = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, alumno.getNombre());
		statement.setInt(2, alumno.getEdad());
		statement.setString(3, alumno.getEspecialidad());
		statement.setInt(4, alumno.getLegajo());

		int filasAfectadas = statement.executeUpdate();
		if (filasAfectadas > 0) {
			System.out.println("El Alumno " + alumno + " modificado correctamente");
		} else {
			System.out.println("No se pudo modificar el alumno: " + alumno);
		}
		statement.close();
	}

	public void eliminarAlumno(Integer legajo) throws SQLException {

		String query = "DELETE FROM Alumnos WHERE legajo = ?";
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, legajo);

		int filasAfectadas = statement.executeUpdate();
		if (filasAfectadas > 0) {
			System.out.println("El Alumno con Legajo: " + legajo + " ha sido eliminado correctamente");
		} else {
			System.out.println("No se pudo eliminar el alumno con Legajo: " + legajo);
		}
		statement.close();

	}

	public void closeConnection() throws SQLException {

		conn.close();
		System.out.println("Conexión cerrada");

	}
}
