package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Area;
import com.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

//	 @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
//	    User existsByEmail(@Param("email") String email);

	
	@Query(value = "SELECT a FROM User a WHERE a.firstName = :currentUsername")
    User findByUserName(@Param("currentUsername") String currentUsername);

	
}
