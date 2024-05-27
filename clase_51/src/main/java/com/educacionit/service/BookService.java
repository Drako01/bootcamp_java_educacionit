package com.educacionit.service;

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
	
	public List<Book> findBooksByTitleLike(String title){
		return bookRepository.findByTitleContaining(title);
	}
}
