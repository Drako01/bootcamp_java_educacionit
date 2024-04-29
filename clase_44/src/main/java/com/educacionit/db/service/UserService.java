package com.educacionit.db.service;

import com.educacionit.db.DatabaseConnection;
import com.educacionit.db.model.User;

public class UserService {
	
	private DatabaseConnection databaseConnection;

	public UserService(DatabaseConnection databaseConnection) {
		super();
		this.databaseConnection = databaseConnection;
	}
	
	public String getUserFullName(Integer id) {
		User user = databaseConnection.getUserById(id);
		if (user != null) {
			return user.getName();
		}
		return null;
	}

}
