package com.shop.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.major.model.Category;
import com.shop.major.repository.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository cRepository;
	
	public List<Category> getAllCategory(){
		return cRepository.findAll();
	}
	
	public void addCategory(Category category) {
		
		cRepository.save(category);
	}

	public void removeCategoryById(int id) {
		cRepository.deleteById(id);
	}
	
	public Optional<Category> getCategoryById(int id) {
		
		return cRepository.findById(id);
	}
	
	
	
	
}
