package com.educacionit.auth;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public AuthResponse register(RegisterRequest request) {
		User user = new User();
		
		user.setUserName(request.getUserName());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setCountry(request.getCountry());
		user.setPassword(request.getPassword());
		
		user.setRole(Role.ADMIN);
		
		userRepository.save(user);
		
		String token = jwtService.getToken(user);
		
		
		return new AuthResponse(token);
	}
}
