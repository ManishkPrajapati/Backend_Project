package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Area;


public interface AreaRepo extends JpaRepository<Area, Integer>{

	@Query(value = "SELECT a FROM Area a WHERE a.area = :areaName")
    Area findByAreaName(@Param("areaName") String areaName);

}
