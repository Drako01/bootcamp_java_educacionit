package com.educacionit.dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.educacionit.excepciones.DBManagerException;

public class DBManager {

    private static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection conn;

    public void conectar() throws DBManagerException{
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
        	System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        	throw new DBManagerException("Error al conectar a la base de datos" + e);
        }
    }


    public void verificarYCrearTabla() throws DBManagerException{
        try {
            Statement statement = conn.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS alumnos (" + "legajo INT PRIMARY KEY,"
                    + "nombre VARCHAR(255) NOT NULL," + "edad INT NOT NULL," + "especialidad VARCHAR(255) NOT NULL)";
            statement.executeUpdate(query);
            System.out.println("Tabla 'Alumnos' verificada y creada si no existía");
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al verificar y crear la tabla: " + e.getMessage());
            throw new DBManagerException("Error al verificar y crear la tabla: " + e);
        }
    }

    public void mostrarAlumnos() throws DBManagerException{
        String query = "SELECT legajo, nombre, edad, especialidad FROM alumnos";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int legajo = resultSet.getInt("legajo");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                String especialidad = resultSet.getString("especialidad");

                System.out.println("Legajo: " + legajo + ", Nombre: " + nombre + ", Edad: " + edad + ", Especialidad: "
                        + especialidad);
            }
        } catch (SQLException e) {
            System.err.println("Error al mostrar alumnos: " + e.getMessage());
            throw new DBManagerException("Error al mostrar alumnos: " + e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el resultSet: " + e.getMessage());
                throw new DBManagerException("Error al cerrar el resultSet: " + e);
                
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el statement: " + e.getMessage());
                throw new DBManagerException("Error al cerrar el statement: " + e);
            }
        }
    }

    public void insertarAlumno(Alumno alumno) throws DBManagerException{
        String query = "INSERT INTO alumnos (legajo, nombre, edad, especialidad) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(query);
            statement.setInt(1, alumno.getLegajo());
            statement.setString(2, alumno.getNombre());
            statement.setInt(3, alumno.getEdad());
            statement.setString(4, alumno.getEspecialidad());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("El Alumno " + alumno + " fue insertado correctamente");
            } else {
                System.out.println("No se pudo insertar el alumno: " + alumno);
                throw new DBManagerException("No se pudo insertar el alumno: " + alumno);
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar alumno: " + e.getMessage());
            throw new DBManagerException("Error al insertar alumno: " + e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el statement: " + e.getMessage());
                throw new DBManagerException("Error al cerrar el statement: " + e);
            }
        }
    }

    public void modificarAlumno(Alumno alumno) throws DBManagerException{
        PreparedStatement statement = null;
        try {
            String query = "UPDATE alumnos SET nombre = ?, edad = ?, especialidad = ? WHERE legajo = ?";
            statement = conn.prepareStatement(query);
            statement.setString(1, alumno.getNombre());
            statement.setInt(2, alumno.getEdad());
            statement.setString(3, alumno.getEspecialidad());
            statement.setInt(4, alumno.getLegajo());

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("El Alumno " + alumno + " modificado correctamente");
            } else {
                System.out.println("No se pudo modificar el alumno: " + alumno);
                throw new DBManagerException("No se pudo modificar el alumno: " + alumno);
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar alumno: " + e.getMessage());
            throw new DBManagerException("Error al modificar alumno" + e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el statement: " + e.getMessage());
                throw new DBManagerException("Error al cerrar el statement: " + e);
            }
        }
    }

    public void eliminarAlumno(Integer legajo) throws DBManagerException{
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM alumnos WHERE legajo = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, legajo);

            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("El Alumno con Legajo: " + legajo + " ha sido eliminado correctamente");
            } else {
                System.out.println("No se pudo eliminar el alumno con Legajo: " + legajo);
                throw new DBManagerException("No se pudo eliminar el alumno con Legajo: " + legajo);
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar alumno: " + e.getMessage());
            throw new DBManagerException("Error al eliminar alumno" + e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar el statement: " + e.getMessage());
                throw new DBManagerException("Error al cerrar el statement: " + e);
            }
        }
    }


    public void closeConnection() throws DBManagerException{
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
            throw new DBManagerException("Error al cerrar la conexión: " + e);
        }
    }
}
