package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.dto.LoginDTO;
import com.educacionit.dto.RegistracionDTO;
import com.educacionit.entity.User;
import com.educacionit.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/registracion")
	public ResponseEntity<User> login(@RequestBody RegistracionDTO registracion) {
		try {
            User registerUser = authenticationService.registrar(registracion);
            return ResponseEntity.ok(registerUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

	}
	@PostMapping("/login")
	public ResponseEntity<User> register(@RequestBody LoginDTO login) {
		User loginUser = authenticationService.autenticar(login);
		
		return ResponseEntity.ok(loginUser);
	}
}
