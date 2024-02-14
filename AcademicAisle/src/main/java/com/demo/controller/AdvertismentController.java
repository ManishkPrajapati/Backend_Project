package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.payload.AdvertismentDto;
import com.demo.service.AdvertismentService;


@RestController
@RequestMapping("api/advertisment")
public class AdvertismentController {
	
	@Autowired
	private AdvertismentService AddService;
	
	
	@Value("${project.image}")
	private String path;
	
	
	//Post - create use
	@PostMapping("/")
	public ResponseEntity<AdvertismentDto> createUser(@RequestBody AdvertismentDto AddDto, @RequestParam("image") MultipartFile img){
		
		
		AdvertismentDto createAddDto = this.AddService.createAdd(AddDto,path, img);
		return new ResponseEntity<>(createAddDto,HttpStatus.CREATED);
	}
	
	@PostMapping("/img")
	public ResponseEntity<String> addImage( ){
		
		return ResponseEntity.ok("working");	
	}

}
