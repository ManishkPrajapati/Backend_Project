package com.demo.service.Impl;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Advertisement;
import com.demo.model.Image;
import com.demo.model.User;
import com.demo.repository.AdvertisementRepo;
import com.demo.repository.CategoryRepo;
import com.demo.repository.UserRepo;
import com.demo.service.AdvertisementService;
import com.demo.utils.ImageUtils;

@Service
public class AdvertisementImpl implements AdvertisementService{
	@Autowired
	private AdvertisementRepo addRepo;
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public void createAdd( Advertisement product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException{
		
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImageToProduct(image3);
        }
//      log.info("Saving new Product. Title: {}; Author email: {}", Advertisement.getAdvTitle(), Advertisement.getUser().getEmail());
        Advertisement productFromDb = addRepo.save(product);
        productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
        addRepo.save(product);
		
	}
	
	
	private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = 	new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(ImageUtils.compressImage(file.getBytes()));
        return image;
    }
	
	public List<Advertisement> listProducts(String title) {
        if (title != null) return addRepo.findByTitle(title);
        return addRepo.findAll();
    }
	
	public Advertisement getProductById(int id) throws IOException {
        Advertisement add =  addRepo.findById(id).orElse(null);
        
//        Image image1= toReturnEntity(add.getImages().get(0));
//        Image image2= toReturnEntity(add.getImages().get(1));
//        Image image3= toReturnEntity(add.getImages().get(2));
//        Image img1 = add.getImages().get(0);
        byte[] base64EncodedImages = ImageUtils.decompressImage(add.getImages().get(0).getBytes());
        
        List<Image> img = new ArrayList<>();
        img.add(img1);
//        img.add(image2);
//        img.add(image3);
        add.setImages(img);
    
       return add;
    }
	
	private Image toReturnEntity(Image img) throws IOException {
        Image image = 	new Image();
        image.setName(img.getName());
        image.setOriginalFileName(img.getOriginalFileName());
        image.setContentType(img.getContentType());
        image.setSize(img.getSize());
        image.setBytes(ImageUtils.decompressImage(img.getBytes()));
        return image;
    }


//	public void deleteProduct(Long id) {
//       Advertisement product = addRepo.findById(id)
//                .orElse(null);
//        if (product != null) {
//            if (product.getUser().getId()==(user.getId())) {
//                addRepo.delete(product);
////                log.info("Product with id = {} was deleted", id);
//            } else {
////                log.error("User: {} haven't this product with id = {}", user.getEmail(), id);
//            }
//        } else {
////            log.error("Product with id = {} is not found", id);
//        }    }

	

	
	
	

}
