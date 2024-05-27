package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.dto.AuthResponse;
import com.educacionit.dto.LoginRequest;
import com.educacionit.dto.RegisterRequest;
import com.educacionit.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
	private AuthService authService=null;
	
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		
		try {
			return ResponseEntity.ok(authService.login(request));
			
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
		try {
			return ResponseEntity.ok(authService.register(request));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
