package com.educacionit.db.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.educacionit.db.DatabaseConnection;
import com.educacionit.db.model.User;

class UserServiceTest2 {

	private static final Integer ID = 9;
	private static final String NOMBRE = "NombreUsuario";

	@Test
	void testGetUserFullName() {

		DatabaseConnection databaseConnectionImpl = mock(DatabaseConnection.class);
		
		User mockUser = new User(ID, NOMBRE);
		when(databaseConnectionImpl.getUserById(ID)).thenReturn(mockUser);
		

		UserService userService = new UserService(databaseConnectionImpl);
		String userName = userService.getUserFullName(ID);

		assertNotNull(userName);
		assertEquals(NOMBRE, userName);
	}

	@Test
	void testGetUserFullNameNok() {

		DatabaseConnection databaseConnectionImpl = mock(DatabaseConnection.class);
		
		//User mockUser = new User(ID, NOMBRE);
		when(databaseConnectionImpl.getUserById(ID)).thenReturn(null);
		

		UserService userService = new UserService(databaseConnectionImpl);
		String userName = userService.getUserFullName(ID);

		assertNull(userName);
	}
}
