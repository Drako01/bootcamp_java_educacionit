package com.educacionit.db;

import com.educacionit.db.model.User;

public interface DatabaseConnection {
	
    User getUserById(Integer userId);
    
}
