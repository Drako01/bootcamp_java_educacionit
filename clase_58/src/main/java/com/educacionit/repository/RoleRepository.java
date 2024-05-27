package com.educacionit.repository;

import com.educacionit.model.Role;

public interface RoleRepository {
	
    Role findByName(String name);
}
