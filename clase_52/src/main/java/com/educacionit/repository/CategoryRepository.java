package com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educacionit.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
