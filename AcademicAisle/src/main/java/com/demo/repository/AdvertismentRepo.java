package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Advertisment;

public interface AdvertismentRepo extends JpaRepository<Advertisment, Integer>{

}
