package com.educacionit.dao.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionit.exception.DBManagerException;

public interface ConnectionDB {

	default Connection getConnection() throws DBManagerException {

		try {
			final String URL = "jdbc:mysql://localhost/bootcamp";
			final String USER = "root";
			final String PASSWORD = "EstaEsLaContrasenaRoot";
			
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			return conn ;
			
		} catch (SQLException sqlExcex) {
			throw new DBManagerException(DBManagerException.ERROR_1, "No se pudo conectar con la DB", sqlExcex);
		}
	}

}
