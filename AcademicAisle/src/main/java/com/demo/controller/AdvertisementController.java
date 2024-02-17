package com.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisement;
import com.demo.payload.AdvertisementDto;
import com.demo.service.Impl.AdvertisementImpl;


@RestController
@RequestMapping("api/prod")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementImpl productService ;
	
	@GetMapping("/all")
	public List<AdvertisementDto> getAllPost(){
		return productService.getAllProducts();
	}
	

    @GetMapping("/product/{id}")
    public ResponseEntity<AdvertisementDto> productInfo(@PathVariable int id) throws IOException {
    	return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProductIMG3(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Advertisement product) throws IOException {
        productService.createAdd( product, file1, file2, file3);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

    @DeleteMapping("/product/delete/{id}")
    	public ResponseEntity<?> deleteProduct(@PathVariable int id) throws IOException {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }

    @GetMapping("/my/products/user/{userId}")
    	public List<Advertisement> getProdByUserId(@PathVariable Integer userId) {
    	System.out.println(userId);
        return productService.getProdByUserId(userId);
    }
    
    @GetMapping("/my/products/category/{catId}")
    public List<Advertisement> getProdByCatId(@PathVariable Integer catId){
    	return productService.getProdByCatId(catId);
    }
    
    @GetMapping("/my/products/area/{areaName}")
    public List<Advertisement> getProdByArea(@PathVariable String areaName){
    	return productService.getProdByArea(areaName);
    }
}
