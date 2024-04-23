package com.educacionit.desafio_08.ejercicio_01.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.educacionit.desafio_08.ejercicio_01.exceptions.DBManagerException;
import com.educacionit.desafio_08.ejercicio_01.models.Provincia;

public class DAOController {
    private static final String DATABASE_NAME = "educacionit";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public ArrayList<Provincia> mostrarProvinciasPorDescripcion(String provincia) throws DBManagerException {
        ArrayList<Provincia> listaProvincias = new ArrayList<>();
        String query = "SELECT id, descripcion, pais_id FROM provincias WHERE descripcion "
        				+ "LIKE '%" + provincia + "%'";
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
            ) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                Integer paisId = resultSet.getInt("pais_id");
                Provincia prov = new Provincia(id, descripcion, paisId);
                listaProvincias.add(prov);
            }
            
            for (Provincia resultProvincia : listaProvincias) {
                String paisDescripcion = obtenerDescripcionPais(resultProvincia.getPaisId());
                System.out.println("La Descripción completa que busca es: " 
                					+ resultProvincia.getDescripcion() +
                                   ", y se encuentra en: " + paisDescripcion);
            }
            
            if (listaProvincias.isEmpty()) {
                System.out.println("No se encontraron provincias que coincidan con la descripción proporcionada.");
            }
            
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
            		"Error al mostrar provincias: " + e.getMessage(), e);
        }
        return listaProvincias;
    }

    private String obtenerDescripcionPais(Integer paisId) throws DBManagerException {
        String query = "SELECT descripcion FROM pais WHERE id = " + paisId;
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
            ) {
            if (resultSet.next()) {
                return resultSet.getString("descripcion");
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
            		"Error al obtener la descripción del país: " + e.getMessage(), e);
        }
        return null;
    }
}
