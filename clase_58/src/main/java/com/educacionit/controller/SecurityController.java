package com.educacionit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecurityController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adminRole() {
		return "Ud tiene Rol de Administrador";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/user")
	public String userRole() {
		return "Ud tiene Rol de Usuario o Admin";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'EMPLOYEE')")
	@GetMapping("/employee")
	public String employeeRole() {
		return "Ud tiene Rol de Empleado o Admin";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
	@GetMapping("/seller")
	public String sellerRole() {
		return "Ud tiene Rol de Vendedor o Admin";
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'EMPLOYEE', 'SELLER')")
	@GetMapping("/cualquiera")
	public String aanyRole() {
		return "Ud tiene cualquier Rol Permitido";
	}
	
}
