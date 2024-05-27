package com.educacionit.repository;

import java.util.List;

import com.educacionit.model.User;
import com.educacionit.model.UserDto;

public interface UserRespository {

	User save(UserDto user);

	List<User> findAll();

	User findOne(String username);

	User createEmployee(UserDto user);

}