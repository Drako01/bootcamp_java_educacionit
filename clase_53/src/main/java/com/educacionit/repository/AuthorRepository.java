package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
