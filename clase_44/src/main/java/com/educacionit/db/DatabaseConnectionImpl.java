package com.educacionit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.educacionit.db.model.User;

public class DatabaseConnectionImpl implements DatabaseConnection {
	
    private static final String URL = "jdbc:mysql://localhost/clase-44";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "EstaEsLaContrasenaRoot";

	@Override
	public User getUserById(Integer userId) {
		try (Connection conn = DriverManager.getConnection(URL,USERNAME, PASSWORD );
				PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
			statement.setInt(1, userId);
			try (ResultSet result = statement.executeQuery()) {
				if (result.next()) {
					return new User(result.getInt("id"), result.getString("full_name"));
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
