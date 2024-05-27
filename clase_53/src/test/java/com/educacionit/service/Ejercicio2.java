package com.educacionit.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Book;



@SpringBootTest
class Ejercicio2 {

	@Autowired
	private BookService bookService;
	
	@Test
	void ejercicio2() {
		
		List<Book> books = bookService.findBooksByTitleLike("Book");
		
		for (Book book : books) {
			System.out.println(book.getId() + " .- " + book.getTitle() + " .- " + book.getPublicationDate());
			System.out.println(book.getAuthor().getName());
			System.out.println(book.getPublisher().getName());
		}
	}

}
