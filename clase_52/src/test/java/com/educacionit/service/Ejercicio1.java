package com.educacionit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Author;
import com.educacionit.entity.Book;
import com.educacionit.entity.Publisher;

@SpringBootTest
class Ejercicio1 {
	
	@Autowired
	private PublisherService publisherService;
	
	@Autowired
	private AuthorService authorService;

	@Test
	void ejercicio1() {
		
		Publisher publisher = new Publisher();
		publisher.setName("Nombre de Editor");
		publisher = publisherService.savePublisher(publisher);
		
		Author author = new Author();
		author.setName("Nombre de Autor con 2 Libros");
		
		Book book1 = new Book();
		book1.setTitle("Nombre del Libro 1");
		book1.setPublicationDate(LocalDate.of(2021, 1, 1));
		book1.setAuthor(author);
		book1.setPublisher(publisher);
		
		Book book2 = new Book();
		book2.setTitle("Nombre del Libro 2");
		book2.setPublicationDate(LocalDate.of(2022, 2, 2));
		book2.setAuthor(author);
		book2.setPublisher(publisher);
		
		/*author.getBooks().add(book1);
		author.getBooks().add(book2);*/
		List<Book> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);
		author.setBooks(books);
		
		authorService.saveAuthor(author);
		
	}

}
