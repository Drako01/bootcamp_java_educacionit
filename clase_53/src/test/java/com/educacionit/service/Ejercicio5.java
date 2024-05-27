package com.educacionit.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class Ejercicio5 {

	@Autowired
	private AuthorService authorService;
	
	@Test
	void ejercicio5() {
		Long authorId = 19l;
		String newNameAuthor = "Nuevo Nombre";
		authorService.updateAuthorName(authorId, newNameAuthor);
	}

}
