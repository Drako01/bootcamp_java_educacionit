package com.educacionit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Author;
import com.educacionit.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public void deleteAuthor(Long authorId) {
		authorRepository.deleteById(authorId);
	}
	
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}
}
