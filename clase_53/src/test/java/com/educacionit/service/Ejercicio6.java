package com.educacionit.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.educacionit.entity.Book;

@SpringBootTest
class Ejercicio6 {

	@Autowired
	private BookService bookService;

	@Test
	void ejercicio6() {
		LocalDate startDate = LocalDate.of(2019, 1, 1);
		LocalDate endDate = LocalDate.of(2020, 10, 1);
		List<Book> books = bookService.findByPublicationDateBetween(startDate, endDate);
		for (Book book : books) {
			System.out.println("Libro Encontrado: " + book.getId() + " .- " + book.getPublicationDate() + " .- "
					+ book.getPublicationDate());

		}
	}

}
