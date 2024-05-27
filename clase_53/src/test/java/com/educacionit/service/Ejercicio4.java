package com.educacionit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class Ejercicio4 {

	@Autowired
	private AuthorService authorService;
	
	@Test
	void ejercicio4() {
		authorService.deleteAuthor(5l);
		
	}

}
