package ejercicios_de_pruba_maven.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicios_de_pruba_maven.entidad.Alumno;
import ejercicios_de_pruba_maven.entidad.Curso;

public class DBManager {
	private static final String DATABASE_NAME = "coderhouse";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
	private static final String USER = "root";
	private static final String PASSWORD = "";

	private Connection connection;

	public Connection getConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				System.err.println("Error al establecer la conexión: " + e.getMessage());
			} finally {
				if (connection != null)
					System.out.println("Conexion exitosa a la Base de Datos " + DATABASE_NAME);
			}
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Conexión cerrada");
			} catch (SQLException e) {
				System.err.println("Error al cerrar la conexión: " + e.getMessage());
			}
		}
	}

	public void mostrarAlumnos() {
		Statement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT dni, nombre, apellido, legajo, id_curso FROM alumnos";
		try {

			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				Integer dni = resultSet.getInt("dni");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String legajo = resultSet.getString("legajo");
				Integer id_curso = resultSet.getInt("id_curso");

				System.out.println("Alumno con DNI Nro " + dni + " es " + nombre + " " + apellido
						+ ", y su Legajo es el Nro: " + legajo
						+ ", y asiste al Curso con ID: " + id_curso);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement o el resultSet: " + e.getMessage());
			}
		}

	}

	public void mostrarAlumnoPorDNI(Integer dni) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = "SELECT nombre, apellido, legajo, id_curso FROM alumnos WHERE dni = ?";

		try {

			statement = connection.prepareStatement(query);
			statement.setInt(1, dni);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String legajo = resultSet.getString("legajo");
				String id_curso = resultSet.getString("id_curso");

				System.out.println("Alumno con DNI Nro " + dni + " Es: " + nombre + " " + apellido
						+ ", y su Legajo es el Nro: " + legajo 
						+ ", y asiste al Curso con ID: " + id_curso);
			} else {
				System.out.println("No se encontró ningún alumno con DNI: " + dni);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement o el resultSet: " + e.getMessage());
			}
		}
	}

	public void insertarAlumno(Alumno alumno) {

		PreparedStatement statement = null;
		String query = "INSERT INTO alumnos (dni, apellido, id_curso, legajo, nombre) VALUES (?, ?, ?, ?, ?)";

		try {
			
			if (!existeCurso(alumno.getIdCurso())) {
	            throw new SQLException("El curso con ID " + alumno.getIdCurso() + " no existe en la tabla cursos");
	        }
			
			statement = connection.prepareStatement(query);
			statement.setInt(1, alumno.getDni());
			statement.setString(2, alumno.getApellido());
			statement.setInt(3, alumno.getIdCurso());
			statement.setInt(4, alumno.hashCode());
			statement.setString(5, alumno.getNombre());
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new SQLException(
						"No se pudo insertar el alumno: " + alumno.getNombre() 
						+ " " + alumno.getApellido());
			}
			System.out.println(
					"El Alumno " + alumno.getNombre() + " " 
			+ alumno.getApellido() + " fue insertado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}

	public void modificarAlumno(Integer dni, String nuevoNombre, String nuevoApellido, Integer id_curso) {

		PreparedStatement statement = null;

		try {
			if (!existeCurso(id_curso)) {
	            throw new SQLException("El curso con ID " + id_curso + " no existe en la tabla cursos");
	        }
			String query = "UPDATE alumnos SET nombre = ?, apellido = ?, id_curso = ?  WHERE dni = ?";
			statement = connection.prepareStatement(query);

			statement.setString(1, nuevoNombre);
			statement.setString(2, nuevoApellido);
			statement.setInt(3, id_curso);
			statement.setInt(4, dni);

			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) {
				throw new SQLException("No se pudo modificar el alumno con DNI " + dni);
			}
			System.out.println("El Alumno con DNI " + dni + " se ha modificado correctamente");

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}

	public void eliminarAlumno(Integer dni) {

		PreparedStatement statement = null;

		try {
			String query = "DELETE FROM alumnos WHERE dni = ?";

			statement = connection.prepareStatement(query);
			statement.setDouble(1, dni);

			int rowsAffected = statement.executeUpdate();
			if (rowsAffected == 0) {
				System.out.println("No se pudo eliminar el alumno con DNI: " + dni);
			} else {
				System.out.println("El Alumno con DNI: " + dni + " ha sido eliminado correctamente");
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement: " + e.getMessage());
			}
		}
	}
	
	public void eliminarTabla(String nombreTabla) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SHOW TABLES LIKE '" + nombreTabla + "'");
			if (resultSet.next()) {
				statement.executeUpdate("DROP TABLE " + nombreTabla);
				System.out.println("La tabla " + nombreTabla + " ha sido eliminada correctamente.");
			} else {
				System.out.println("La tabla " + nombreTabla + " no existe.");
			}
		} catch (SQLException e) {
			System.err.println("Error al eliminar la tabla: " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				System.err.println("Error al cerrar el statement o el resultSet: " + e.getMessage());
			}
		}
	}
	
	public void insertarCurso(Curso curso) {
	    PreparedStatement statement = null;
	    String query = "INSERT INTO cursos (descripcion, titulo) VALUES (?, ?)";

	    try {
	        statement = connection.prepareStatement(query);
	        statement.setString(1, curso.getDescripcion());
	        statement.setString(2, curso.getTitulo());

	        int rowsAffected = statement.executeUpdate();

	        if (rowsAffected == 0) {
	            throw new SQLException("No se pudo insertar el curso: " + curso.getTitulo());
	        }
	        System.out.println("El curso: " + curso.getTitulo() + " fue insertado correctamente");

	    } catch (SQLException e) {
	        System.err.println(e.getMessage());
	    } finally {
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            System.err.println("Error al cerrar el statement: " + e.getMessage());
	        }
	    }
	}

	private boolean existeCurso(Integer idCurso) {
	    String query = "SELECT COUNT(*) FROM cursos WHERE id_curso = ?";
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, idCurso);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count > 0;
	        }
	    } catch (SQLException e) {
	        System.err.println("Error al verificar si existe el curso: " + e.getMessage());
	    }
	    return false;
	}
}
