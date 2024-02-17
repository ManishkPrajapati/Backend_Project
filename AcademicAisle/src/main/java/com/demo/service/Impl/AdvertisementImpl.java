package com.demo.service.Impl;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Advertisement;
import com.demo.model.Category;
import com.demo.model.User;
import com.demo.payload.AdvertisementDto;
import com.demo.payload.CategoryDto;
import com.demo.repository.AdvertisementRepo;

import com.demo.repository.UserRepo;
import com.demo.service.AdvertisementService;


@Service
public class AdvertisementImpl implements AdvertisementService{
	@Autowired
	private AdvertisementRepo addRepo;
	
	@Autowired
	private Cloudinary cloudinary;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public void createAdd( Advertisement product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException{
		
		String img1 = uploadFile(file1);
		String img2 = uploadFile(file2);
		String img3 = uploadFile(file3);
		product.setImage1(img1);
		product.setImage2(img2);
		product.setImage3(img3);
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
	public AdvertisementDto getProductById(int id) throws IOException {
		System.out.println("inside to get product");
		 Advertisement add = this.addRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Advertisement","id", id));
		 System.out.println(add);
		 AdvertisementDto adto = this.modelMapper.map(add, AdvertisementDto.class);
		 return adto;
	}


	public List<AdvertisementDto> getAllProducts() {
		List<Advertisement> adds = this.addRepo.findAll();
		List<AdvertisementDto> prod = adds.stream().map((cat) -> this.modelMapper.map(cat, AdvertisementDto.class))
				.collect(Collectors.toList());

		return prod;
	}


	public void deleteProduct(int id) throws IOException{
		this.addRepo.deleteById(id);
		
	}


	public List<Advertisement> getProdByUserId(Integer userId) {
	    

	    // Get the list of advertisements associated with the user
	    List<Advertisement> advertisements = addRepo.getByUserId(userId);

	    // Convert the advertisements to AdvertisementDto objects
//	    List<AdvertisementDto> advertisementDtos = advertisements.stream()
//	            .map(advertisement -> modelMapper.map(advertisement, AdvertisementDto.class))
//	            .collect(Collectors.toList());

	    return advertisements;
	}
	
	

}
