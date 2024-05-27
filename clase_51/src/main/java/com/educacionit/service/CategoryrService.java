package com.educacionit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educacionit.entity.Category;
import com.educacionit.repository.CategoryRepository;

@Service
public class CategoryrService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	public List<Category> findAllCategorys() {
		return categoryRepository.findAll();
	}
}
