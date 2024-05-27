package com.educacionit.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Book;

@SpringBootTest
class Ejercicio3 {

	@Autowired
	private BookService bookService;

	@Test
	void ejercicio3MayorQue() {

		List<Book> books = bookService.findBooksGreaterThan(63l);

		for (Book book : books) {
			System.out.println("Libro Encontrado: " + book.getId() + " .- " + book.getTitle() + " .- " + book.getPublicationDate());

		}
	}

	@Test
	void ejercicio3MayorOIgualQue() {

		List<Book> books = bookService.findBooksGreaterThanEqual(63l);

		for (Book book : books) {
			System.out.println("Libro Encontrado: " + book.getId() + " .- " + book.getTitle() + " .- " + book.getPublicationDate());

		}
	}

	@Test
	void ejercicio3MenorOIgualQue() {

		List<Book> books = bookService.findBooksLessThanEqual(63l);

		for (Book book : books) {
			System.out.println("Libro Encontrado: " + book.getId() + " .- " + book.getTitle() + " .- " + book.getPublicationDate());
		
		}
	}
	
	@Test
	void ejercicio3CantidadDeRegistros() {

		Long books = bookService.bookCount();

		System.out.println("Cantidad de Libros Encontrados: " + books + " Unidades");
	}
}
