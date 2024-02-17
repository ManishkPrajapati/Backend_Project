package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Advertisement;

public interface AdvertisementRepo extends JpaRepository<Advertisement, Integer>{
	
	List<Advertisement> findByTitle(String title);

	Optional<Advertisement> findById(Long id);


	@Query(value = "SELECT * FROM advertisement WHERE user_id = :userId", nativeQuery = true)
    List<Advertisement> getByUserId(Integer userId);
	
}
