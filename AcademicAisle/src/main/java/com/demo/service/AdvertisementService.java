package com.demo.service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisement;
import com.demo.model.User;

public interface AdvertisementService {
	
	public void createAdd( Advertisement product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException;
	 
//	List<Advertisement> getAllAdd();
	
//	Advertisement updateAdd(Advertisement add, Integer addId);
//	
//	Advertisement deleteAdd(Integer addId);
	
//	Advertisement getAddById(Integer addId);
	
//	Advertisement getAddByCategory(String addCategory);
	
//	List<Advertisement> listProducts(String title);
	
	List<Advertisement> getAllProducts();
	
	Advertisement getProductById(int id) throws IOException;
	
//	void deleteProduct(int id);
	
	
}
