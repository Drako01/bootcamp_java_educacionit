package com.educacionit.service;

import java.util.List;
import java.util.Optional;

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
	
	public void updateAuthorName(Long authorId, String  newAuthorName) {
		Optional<Author> authorOptional  = authorRepository.findById(authorId);
		if(authorOptional.isPresent()) {
			Author author = authorOptional.get();
			author.setName(newAuthorName);
			authorRepository.save(author);
		}
		
	}
}
