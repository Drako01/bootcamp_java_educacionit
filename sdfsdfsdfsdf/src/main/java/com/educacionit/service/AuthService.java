package com.educacionit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educacionit.dto.AuthResponse;
import com.educacionit.dto.LoginRequest;
import com.educacionit.dto.RegisterRequest;
import com.educacionit.entity.Rol;
import com.educacionit.entity.User;
import com.educacionit.jwt.JwtService;
import com.educacionit.repository.RolRepository;
import com.educacionit.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	public AuthResponse login(LoginRequest request) {
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
		
		String token = jwtService.getToken(user);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		
		return authResponse;
	}

	
	
	
	public AuthResponse register(RegisterRequest request) {

		User user = new User();
		user.setEmail(request.getEmail());
		user.setFullName(request.getFullname());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		Rol defaultRol = rolRepository.findByName("USER").get();
		user.addRole(defaultRol);
		
		userRepository.save(user);

		AuthResponse authResponse = new AuthResponse();

		authResponse.setToken(jwtService.getToken(user));

		return authResponse;
	}

}
