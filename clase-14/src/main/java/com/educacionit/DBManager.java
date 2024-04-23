package com.educacionit;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.educacionit.dao.model.Alumno;
import com.educacionit.exception.DBManagerException;
import com.educacionit.exception.DBManagerObtenerAlumnoException;

public class DBManager implements Closeable, IDBManager {

	private Connection conn;

	@Override
	public void conectar() throws DBManagerException {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bootcamp", "root", "EstaEsLaContrasenaRoot");
			System.out.println("La conexion se establecio correctamente");

		} catch (SQLException sqlExcex) {
			throw new DBManagerException(DBManagerException.ERROR_1, "No se pudo conectar con la DB", sqlExcex);
		}
	}

	@Override
	public void mostrarAlumnos() throws DBManagerException {

		String query = "select legajo, nombre, edad, especialidad from alumnos";

		try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query);) {

			while (resultSet.next()) {
				Integer legajo = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				Integer edad = resultSet.getInt("edad");
				String especialidad = resultSet.getString("especialidad");

				System.out.printf("Legajo = [%d] - Nombre = [%s] - Edad = [%d] - Especialidad = [%s]\n", legajo, nombre,
						edad, especialidad);
			}

		} catch (SQLException sqlExcex) {
			throw new DBManagerException(DBManagerException.ERROR_2,
					"No fue posible listar los alumnos por la siguiente causa: " + sqlExcex.getMessage(), sqlExcex);
		}
	}


	@Override
	public ArrayList<Alumno> obtenerAlumnos() throws DBManagerException {

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		String query = "select legajo, nombre, edad, especialidad from alumnos";
		try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(query);) {

			while (resultSet.next()) {

				Integer legajo = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				Integer edad = resultSet.getInt("edad");
				String especialidad = resultSet.getString("especialidad");

				// Alumno unAlumno = new Alumno(legajo, nombre, edad, especialidad);
				Alumno unAlumno = new Alumno(legajo, nombre);
				unAlumno.setEdad(edad);
				unAlumno.setEspecialidad(especialidad);

				// Agregamos un alumno a nuestra coleccion
				listaAlumnos.add(unAlumno);
			}

		} catch (SQLException sqlExcex) {
			throw new DBManagerException(DBManagerException.ERROR_3,
					"No fue posible obtener los alumnos por la siguiente causa: " + sqlExcex.getMessage(), sqlExcex);
		}

		return listaAlumnos;
	}

	@Override
	public Alumno obtenerAlumno(Integer legajo) throws DBManagerException {

		String query = "select nombre, edad, especialidad from alumnos where legajo = ?";

		ResultSet resultSet = null;

		try (PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, legajo);
			resultSet = statement.executeQuery();

			Boolean hayRegistros = resultSet.next();

			if (hayRegistros == false) {
				throw new DBManagerObtenerAlumnoException(DBManagerException.ERROR_4,
						"No pude encontrar al alumno con legajo: " + legajo);
			}

			String nombre = resultSet.getString("nombre");
			Integer edad = resultSet.getInt("edad");
			String especialidad = resultSet.getString(3);

			// Voy a crear mi clase Alumno
			Alumno unAlumno = new Alumno(legajo, nombre);
			unAlumno.setEdad(edad);
			unAlumno.setEspecialidad(especialidad);

			return unAlumno;

		} catch (SQLException sqlExcex) {
			throw new DBManagerException(DBManagerException.ERROR_4, "No fue posible obtener el alumno de legajo: "
					+ legajo + ". Por el error: " + sqlExcex.getMessage(), sqlExcex);
		} finally {
			try {
				resultSet.close();
			} catch (SQLException ex) {
				System.err.println("No pude cerrar el statement");
			}
		}
	}

	@Override
	public void insertarAlumno(Alumno alumno) throws DBManagerException {

		String query = "insert into alumnos (legajo, nombre, edad, especialidad) values (?, ?, ?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(query);) {
			statement.setInt(1, alumno.getLegajo());
			statement.setString(2, alumno.getNombre());
			statement.setInt(3, alumno.getEdad());
			statement.setString(4, alumno.getEspecialidad());

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_5, "El alumno: " + alumno + " NO fue insertado");
			}

			System.out.println("El alumno: " + alumno + " fue insertado de forma correcta");

		} catch (SQLException sqlExec) {
			throw new DBManagerException(DBManagerException.ERROR_5, "No pude insertar el alumno " + alumno, sqlExec);
		}

	}

	@Override
	public void modificarAlumno(Alumno alumno) throws DBManagerException {

		String query = "update alumnos set nombre = ?, edad = ?, especialidad = ? WHERE legajo = ?";
		try (PreparedStatement statement = conn.prepareStatement(query);) {

			// statement = conn.prepareStatement(query);

			statement.setString(1, alumno.getNombre());
			statement.setInt(2, alumno.getEdad());
			statement.setString(3, alumno.getEspecialidad());
			statement.setInt(4, alumno.getLegajo());

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_6,
						"No fue posible modificar el alumno " + alumno);
			}

			System.out.println("El alumno " + alumno + " fue modificado de forma correcta");

		} catch (SQLException exec) {
			throw new DBManagerException(DBManagerException.ERROR_6, "No pude modificar el alumno " + alumno, exec);
		}

	}

	@Override
	public void eliminarAlumno(Integer legajo) throws DBManagerException {

		String query = "delete from alumnos WHERE legajo = ?";
		try (PreparedStatement statement = conn.prepareStatement(query);) {

			statement.setInt(1, legajo);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new DBManagerException(DBManagerException.ERROR_7,
						"No pude eliminar al alumno con legajo: " + legajo);
			}

			System.out.println("Se borro el alumno con legajo: " + legajo);

		} catch (SQLException exec) {
			throw new DBManagerException(DBManagerException.ERROR_7,
					"No pude eliminar al alumno. Error: " + exec.getMessage(), exec);
		}
	}


	@Override
	public void close() throws IOException {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException exec) {
			throw new IOException(exec);
		}
	}

}
