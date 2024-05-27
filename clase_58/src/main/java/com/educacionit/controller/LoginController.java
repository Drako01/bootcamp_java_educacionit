package com.educacionit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educacionit.config.TokenProvider;
import com.educacionit.model.AuthToken;
import com.educacionit.model.LoginUser;
import com.educacionit.model.User;
import com.educacionit.model.UserDto;
import com.educacionit.repository.UserRespository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRespository userService;

	@PostMapping(value = "/authenticate")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

	@PostMapping(value = "/register")
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }
}