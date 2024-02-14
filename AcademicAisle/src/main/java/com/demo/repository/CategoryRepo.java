package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.demo.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	@Query(value = "SELECT a FROM Category a WHERE a.name = :name")
	Category findByCatName(@Param("name") String name);
	

}
