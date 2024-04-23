package com.educacionit.desafio_08.ejercicio_02.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.educacionit.desafio_08.ejercicio_02.exceptions.DBManagerException;
import com.educacionit.desafio_08.ejercicio_02.models.Pais;
import com.educacionit.desafio_08.ejercicio_02.models.Provincia;

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
    
    public ArrayList<Provincia> mostrarTodasLasProvincias() throws DBManagerException {
    	
    	ArrayList<Provincia> listaProvincias = new ArrayList<>();
    	String query = "SELECT id, descripcion, pais_id FROM provincias";
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
                System.out.println("La Provincia de " 
                					+ resultProvincia.getDescripcion() +
                                   " se encuentra en " + paisDescripcion 
                                   + " y su ID es: " +  resultProvincia.getId());
            }
            
            if (listaProvincias.isEmpty()) {
                System.out.println("No se encontraron Provincias.");
            }
            
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
            		"Error al mostrar provincias: " + e.getMessage(), e);
        }
        return listaProvincias;
    }
    
    public ArrayList<Pais> mostrarTodosLosPaises() throws DBManagerException {
    	ArrayList<Pais> listaPaises = new ArrayList<>();
		String query = "SELECT id, descripcion FROM pais";
		try (
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
			) {
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String descripcion = resultSet.getString("descripcion");
				Pais pais = new Pais(id, descripcion);
				listaPaises.add(pais);	
			}
			
			for (Pais pais : listaPaises) {                
                System.out.println("Pais #" + pais.getId() + " " + pais.getDescripcion());
            }
            
            if (listaPaises.isEmpty()) {
                System.out.println("No se encontraron Paises.");
            }
		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_1, "Error al mostrar alumnos: " + e.getMessage(), e);
		}
		return listaPaises;
	}
    
    public void insertarProvincia(Provincia provincia) throws DBManagerException {
		String query = "INSERT INTO provincias ( descripcion, pais_id) VALUES (?,?)";
		try (
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement statement = conn.prepareStatement(query)
			) {
			statement.setString(1, provincia.getDescripcion());
			statement.setInt(2, provincia.getPaisId());
			
			int rowsAffected = statement.executeUpdate();

			if (rowsAffected == 0) throw new DBManagerException(
				DBManagerException.ERROR_4, "No se pudo insertar la Provincia: " 
									+ provincia.getDescripcion());
			else System.out.println("La Provincia " + provincia.getDescripcion() 
									+ " ha sido insertada correctamente");

		} catch (SQLException e) {
			throw new DBManagerException(
				DBManagerException.ERROR_4, "Error al insertar la Provincia: " + e.getMessage(), e);
		}
	}
    
    public void editarProvincia(Provincia provincia) throws DBManagerException {
        String query = "UPDATE provincias SET descripcion = ?, pais_id = ? WHERE id = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);
        ) {
            statement.setString(1, provincia.getDescripcion());
            statement.setInt(2, provincia.getPaisId());
            statement.setInt(3, provincia.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new DBManagerException(
                    DBManagerException.ERROR_4, "No se encontró ninguna provincia con el ID: " 
                    			+ provincia.getId());
            } else {
                System.out.println("La Provincia " + provincia.getDescripcion()
                					+ " ha sido editada correctamente");
            }
        } catch (SQLException e) {
            throw new DBManagerException(
                DBManagerException.ERROR_4, "Error al editar la Provincia: " + e.getMessage(), e);
        }
    }

    public void eliminarProvincia(int idProvincia) throws DBManagerException {
        String query = "DELETE FROM provincias WHERE id = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);
        ) {
            statement.setInt(1, idProvincia);
            
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new DBManagerException(DBManagerException.ERROR_4, 
                			"No se encontró ninguna provincia con el ID especificado: " 
                			+ idProvincia);
            } else {
                System.out.println("La provincia con ID " + idProvincia 
                					+ " ha sido eliminada correctamente");
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_4, 
            				"Error al eliminar la provincia: " + e.getMessage(), e);
        }
    }

    public Integer obtenerIdPaisPorProvincia(int idProvincia) throws DBManagerException {
        Integer idPais = null;
        String query = "SELECT pais_id FROM provincias WHERE id = ?";
        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement statement = conn.prepareStatement(query);
        ) {
            statement.setInt(1, idProvincia);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idPais = resultSet.getInt("pais_id");
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, 
                "Error al obtener el ID del país por provincia: " + e.getMessage(), e);
        }
        return idPais;
    }


}
