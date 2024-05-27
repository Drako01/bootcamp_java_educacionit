package com.educacionit.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping(value = "register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
		
		return null;
	}

	@PostMapping(value = "login")
	public String login() {
		return null;
	}
}
