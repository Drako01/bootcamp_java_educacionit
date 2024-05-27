package com.educacionit.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	//List<Book> findByPublicationDate(LocalDate publicationDate);
	//Buscar por LIKE
	List<Book> findByTitleContaining(String title);
	//Buscar por ID mayor que
	List<Book> findByIdGreaterThan(Long id);
	//Buscar por ID mayor o Igual que
	List<Book> findByIdGreaterThanEqual(Long id);
	//Buscar por ID menor que
	List<Book> findByIdLessThan(Long id);
	//Buscar por ID menor o Igual que
	List<Book> findByIdLessThanEqual(Long id);
	//Buscar por ID sino es
	List<Book> findByIdNot(Long id);
	//Contar Registros
	long count();
	//Busqueda por Rango de Fechas
	List<Book> findByPublicationDateBetween(LocalDate startDate,LocalDate endDate);
}
