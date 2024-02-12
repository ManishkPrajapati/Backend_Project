package com.demo.service;

import java.util.List;

import com.demo.model.Advertisment;

public interface AdvertismentService {
	
	Advertisment createAdd(Advertisment add);
	 
	List<Advertisment> getAllAdd();
	
	Advertisment updateAdd(Advertisment add, Integer addId);
	
	Advertisment deleteAdd(Integer addId);
	
	Advertisment getAddById(Integer addId);
	
	Advertisment getAddByCategory(String addCategory);
	
	
	
}
