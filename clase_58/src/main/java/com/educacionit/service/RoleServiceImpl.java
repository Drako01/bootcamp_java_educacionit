package com.educacionit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.dao.RoleDao;
import com.educacionit.model.Role;
import com.educacionit.repository.RoleRepository;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleRepository {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        // Find role by name using the roleDao
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
