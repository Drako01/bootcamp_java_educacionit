package com.educacionit.mysql;

import java.sql.*;

public class EjemploDeCrudBootcamp {


    private static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "";

    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            
            insertarUsuario(connection, "Alejandro", 46);
           
            mostrarUsuarios(connection);
            
            actualizarUsuario(connection, 2, "Alejandro Daniel", 47);
            
            mostrarUsuarios(connection);
            
            eliminarUsuario(connection, 1);
            
            mostrarUsuarios(connection);
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertarUsuario(Connection connection, String nombre, int edad) throws SQLException {
        String insertQuery = "INSERT INTO usuarios (nombre, edad) VALUES (?, ?)";
        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
            insertStatement.setString(1, nombre);
            insertStatement.setInt(2, edad);
            insertStatement.executeUpdate();
            insertStatement.close();
            System.out.println("Usuario insertado correctamente.");
        }
        
    }

    private static void mostrarUsuarios(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM usuarios";
        try (Statement selectStatement = connection.createStatement();
             ResultSet resultSet = selectStatement.executeQuery(selectQuery)) {

            System.out.println("Lista de usuarios:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int edad = resultSet.getInt("edad");
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad);
            }
            selectStatement.close();
            resultSet.close();
            System.out.println();
        }
        
    }

    private static void actualizarUsuario(Connection connection, int id, String nuevoNombre, int nuevaEdad) throws SQLException {
        String updateQuery = "UPDATE usuarios SET nombre = ?, edad = ? WHERE id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
            updateStatement.setString(1, nuevoNombre);
            updateStatement.setInt(2, nuevaEdad);
            updateStatement.setInt(3, id);
            updateStatement.executeUpdate();
            updateStatement.close();
            System.out.println("Usuario actualizado correctamente.");
        }
        
    }

    private static void eliminarUsuario(Connection connection, int id) throws SQLException {
        String deleteQuery = "DELETE FROM usuarios WHERE id = ?";
        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setInt(1, id);
            deleteStatement.executeUpdate();
            deleteStatement.close();
            System.out.println("Usuario eliminado correctamente.");
        }
    }
}
