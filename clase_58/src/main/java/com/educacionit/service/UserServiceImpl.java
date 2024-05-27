package com.educacionit.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.educacionit.dao.UserDao;
import com.educacionit.model.Role;
import com.educacionit.model.User;
import com.educacionit.model.UserDto;
import com.educacionit.repository.RoleRepository;
import com.educacionit.repository.UserRespository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserRespository {

    @Autowired
    private RoleRepository roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    // Load user by username
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    // Get user authorities
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    // Find all users
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    // Find user by username
    @Override
    public User findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User save(UserDto user) {
        User nUser = user.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        Role role;
        if(user.getRol() != null) {
        	role = roleService.findByName(user.getRol().toUpperCase());
        } else {
        	role = roleService.findByName("USER");
        }
        
        
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }

    @Override
    public User createEmployee(UserDto user) {
        User nUser = user.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role employeeRole = roleService.findByName("EMPLOYEE");
        Role customerRole = roleService.findByName("USER");

        Set<Role> roleSet = new HashSet<>();
        if (employeeRole != null) {
            roleSet.add(employeeRole);
        }
        if (customerRole != null) {
            roleSet.add(customerRole);
        }

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }
}