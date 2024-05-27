package com.educacionit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByName(String name);
}
