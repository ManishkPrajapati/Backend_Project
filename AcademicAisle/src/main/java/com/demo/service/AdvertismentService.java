package com.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisment;
import com.demo.payload.AdvertismentDto;

public interface AdvertismentService {
	
	AdvertismentDto createAdd(AdvertismentDto addDto, String path, MultipartFile img);

//	String uploadImage(String path, MultipartFile image);
	 
//	List<AdvertismentDto> getAllAdd();
//	
//	AdvertismentDto updateAdd(AdvertismentDto add, Integer addId);
//	
//	AdvertismentDto deleteAdd(Integer addId);
//	
//	AdvertismentDto getAddById(Integer addId);
//	
//	AdvertismentDto getAddByCategory(String addCategory);
	
	
	
}
