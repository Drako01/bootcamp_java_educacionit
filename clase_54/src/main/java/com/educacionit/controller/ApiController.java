package com.educacionit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ApiController {

	@GetMapping(value = "demo")
	public String holaMundo() {
		return "Hola mundo";
	}
}
