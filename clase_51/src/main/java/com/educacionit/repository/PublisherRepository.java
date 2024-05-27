package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

	void deleteByName(Publisher publisher);
}
