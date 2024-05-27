package com.educacionit.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Book;
import com.educacionit.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	public void deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public List<Book> findBooksByTitleLike(String title) {
		return bookRepository.findByTitleContaining(title);
	}

	public List<Book> findBooksGreaterThan(Long id) {
		return bookRepository.findByIdGreaterThan(id);
	}

	public List<Book> findBooksGreaterThanEqual(Long id) {
		return bookRepository.findByIdGreaterThanEqual(id);
	}

	public List<Book> findBooksLessThan(Long id) {
		return bookRepository.findByIdLessThan(id);
	}

	public List<Book> findBooksLessThanEqual(Long id) {
		return bookRepository.findByIdLessThanEqual(id);
	}
	
	public List<Book> findBooksNot(Long id) {
		return bookRepository.findByIdNot(id);
	}
	
	public Long bookCount() {
		return bookRepository.count();
	}
	
	public List<Book> findByPublicationDateBetween(LocalDate startDate,LocalDate endDate) {
		return bookRepository.findByPublicationDateBetween(startDate, endDate);
	}
}
