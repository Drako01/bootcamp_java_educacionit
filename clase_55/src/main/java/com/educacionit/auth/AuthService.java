package com.educacionit.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educacionit.jwt.JwtService;
import com.educacionit.user.Role;
import com.educacionit.user.User;
import com.educacionit.user.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	public AuthResponse register(RegisterRequest request) {

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setFirstname(request.getFirstname());
		user.setLastname(request.getLastname());
		user.setCountry(request.getCountry());
		user.setRole(Role.USER);

		userRepository.save(user);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setToken(jwtService.getToken(user));

		return authResponse;
	}

	public AuthResponse login(LoginRequest request) {
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getUsername(), 
						request.getPassword())
				);
		
		Optional<User >userOptional = userRepository.findByUsername(request.getUsername());
		
		User user = null;
		
		if(userOptional.isPresent()) {
			user = userOptional.get();
		}
		
		String token = jwtService.getToken(user);
		
		AuthResponse authResponse = new AuthResponse();
		
		authResponse.setToken(token);
		
		return authResponse;
	}
}
