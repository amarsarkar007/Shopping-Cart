package com.shop.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.major.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
