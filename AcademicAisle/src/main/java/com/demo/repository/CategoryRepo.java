package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
