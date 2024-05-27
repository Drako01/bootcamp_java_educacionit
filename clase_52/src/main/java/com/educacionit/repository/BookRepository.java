package com.educacionit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	//List<Book> findByPublicationDate(LocalDate publicationDate);
	List<Book> findByTitleContaining(String title);
}
