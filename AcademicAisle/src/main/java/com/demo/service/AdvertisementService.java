package com.demo.service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisement;
import com.demo.model.User;
import com.demo.payload.AdvertisementDto;

public interface AdvertisementService {
	
	void createAdd( Advertisement product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;
	 
	
	List<AdvertisementDto> getAllProducts();
	
	AdvertisementDto getProductById(int id) throws IOException;
	
   void deleteProduct(int id) throws IOException;
   
   List<Advertisement> getProdByUserId(Integer userId);
	
	
}
