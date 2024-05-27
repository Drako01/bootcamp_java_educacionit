package com.educacionit.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	
	@Autowired
	private AuthService authService=null;
	
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) throws Exception {

		try {
			return ResponseEntity.ok(
					authService.register(request)
					);
		} catch (Exception ex) {
			throw new Exception("No se pudo registrar al usuario: " + request);
		}
	}

	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(
				authService.login(request)
				);
	}
	
}
