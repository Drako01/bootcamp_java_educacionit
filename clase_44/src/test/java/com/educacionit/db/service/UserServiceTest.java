package com.educacionit.db.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.educacionit.db.DatabaseConnection;
import com.educacionit.db.DatabaseConnectionImpl;

class UserServiceTest {

	private Connection conn;

	private static final String URL = "jdbc:mysql://localhost/clase-44";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "EstaEsLaContrasenaRoot";

	private static final Integer ID = 1213;
	private static final String NOMBRE = "NombreUsuario";

	@BeforeEach
	void setUp() throws SQLException {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		createTestData();
	}

	private void createTestData() throws SQLException {

		String query = "insert into users (id, full_name) values (?,?)";
		try (PreparedStatement s = conn.prepareStatement(query)) {
			s.setInt(1, ID);
			s.setString(2, NOMBRE);
			s.executeUpdate();
		}
	}

	@Test
	void testGetUserFullName() {

		DatabaseConnection databaseConnectionImpl = new DatabaseConnectionImpl();
		UserService userService = new UserService(databaseConnectionImpl);
		String userName = userService.getUserFullName(ID);

		assertNotNull(userName);
		assertEquals(NOMBRE, userName);
	}
	
	
	@Test
	void testGetUserFullNameError() {

		DatabaseConnection databaseConnectionImpl = new DatabaseConnectionImpl();
		UserService userService = new UserService(databaseConnectionImpl);
		String userName = userService.getUserFullName(null);

		assertNull(userName);
	}

	@AfterEach
	void tearDown() throws SQLException {
		if (conn != null) {
			cleanData();
			conn.close();
		}
	}

	private void cleanData() throws SQLException {
		String query = "delete from users where id = ?";
		try (PreparedStatement s = conn.prepareStatement(query)) {
			s.setInt(1, ID);
			s.executeUpdate();
		}

	}

}
