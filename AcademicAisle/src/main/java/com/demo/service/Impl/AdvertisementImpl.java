package com.demo.service.Impl;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Advertisement;

import com.demo.repository.AdvertisementRepo;

import com.demo.repository.UserRepo;
import com.demo.service.AdvertisementService;


@Service
public class AdvertisementImpl implements AdvertisementService{
	@Autowired
	private AdvertisementRepo addRepo;
	
	@Autowired
	private Cloudinary cloudinary;
	

	@Override
	public void createAdd( Advertisement product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException{
		
		String img1 = uploadFile(file1);
		String img2 = uploadFile(file2);
		String img3 = uploadFile(file3);
		List<String> images = new ArrayList<>();
		images.add(img1);
		images.add(img2);
		images.add(img3);
		product.setImages(images);
        addRepo.save(product);
		
	}
	
	
	public String uploadFile(MultipartFile multipartFile) throws IOException {
        return cloudinary.uploader()
                .upload(multipartFile.getBytes(),
                        Map.of("public_id", UUID.randomUUID().toString()))
                .get("url")
                .toString();
    }


	@Override
	public Advertisement getProductById(int id) throws IOException {
		// TODO Auto-generated method stub
		return this.addRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Advertisement","id", id));
	}


	public List<Advertisement> getAllProducts() {
		return this.addRepo.findAll();
	}
	
	

}
