package com.educacionit.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educacionit.model.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Integer> {
    Role findRoleByName(String name);
}