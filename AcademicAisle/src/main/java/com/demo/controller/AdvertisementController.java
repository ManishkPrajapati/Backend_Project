package com.demo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisement;
import com.demo.model.User;
import com.demo.service.AdvertisementService;
import com.demo.service.Impl.AdvertisementImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AdvertisementController {
	
	private final AdvertisementImpl productService ;
	
	@GetMapping("/all/")
	public List<Advertisement> getAllPost(){
		return productService.getAllProducts();
	}
	

    @GetMapping("/product/{id}")
    public Advertisement productInfo(@PathVariable int id) throws IOException {
    	return productService.getProductById(id);
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Advertisement product) throws IOException {
        productService.createAdd( product, file1, file2, file3);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }

//    @PostMapping("/product/delete/{id}")
//    	public String deleteProduct(@PathVariable int id) {
//        productService.deleteProduct(id);
//        return "redirect:/my/products";
//    }

//    @GetMapping("/my/products/{userId}")
//    	public String userProducts(int userId , Model model) {
//        User user = productService.getUserByPrincipal(principal);
//        model.addAttribute("user", user);
//        model.addAttribute("products", user.getProducts());
//        return "my-products";
//    }
}
