package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Advertisement;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Integer>{
	
	List<Advertisement> findByTitle(String title);

	Optional<Advertisement> findById(Long id);
}
