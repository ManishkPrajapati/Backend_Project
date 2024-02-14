package com.demo.service.Impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.exception.UserAlreadyExistsException;
import com.demo.model.Advertisment;
import com.demo.model.Area;
import com.demo.model.Category;
import com.demo.model.User;
import com.demo.payload.AdvertismentDto;
import com.demo.repository.AdvertismentRepo;
import com.demo.repository.CategoryRepo;
import com.demo.repository.UserRepo;
import com.demo.service.AdvertismentService;

@Service
public class AdvertismentImpl implements AdvertismentService{
	@Autowired
	private AdvertismentRepo addRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo catRepo;

	@Override
	public AdvertismentDto createAdd(AdvertismentDto addDto, String path, MultipartFile img) {

		Advertisment add = new Advertisment();
		Advertisment added = null;
		
			try {
				try {
					add = this.dtoToAdd(addDto,path, img);
				} catch (UserAlreadyExistsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				added = this.addRepo.save(add);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return this.AddToDto(added);		
			
	}
	
	
	public Advertisment dtoToAdd(AdvertismentDto AddDto, String path, MultipartFile img) throws UserAlreadyExistsException, IOException {

		 // Retrieve currently authenticated user
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUsername = authentication.getName();

        // Retrieve user from database based on username (or any other identifier)
        User user = userRepo.findByUserName(AddDto.getUser().getFirstName());

        
        Category cat = catRepo.findByCatName(AddDto.getCategory().getName());
        
        
        Advertisment add = modelMapper.map(AddDto, Advertisment.class);
        
        add.setUser(user);
        add.setCategory(cat);
        
        String name = img.getOriginalFilename();
        String filepath = path + File.separator+name;
        
        File f = new File(path);
        if(!f.exists()) {
        	f.mkdir();
        }
        
        Files.copy(img.getInputStream(), Paths.get(filepath));
        
        add.setImage(filepath);

        return addRepo.save(add);
    }
	
	public AdvertismentDto AddToDto(Advertisment add) {		
		Category catDto = this.modelMapper.map(add.getCategory(), Category.class);
		User userDto = this.modelMapper.map(add.getUser(), User.class);
		AdvertismentDto AddDto = new AdvertismentDto();
		AddDto.setCategory(catDto);
		AddDto.setUser(userDto);
		return AddDto;
	}


//	@Override
//	public String uploadImage(String path, MultipartFile image) {
//		String name = image.getOriginalFilename();
//        String filepath = path + File.separator+name;
//        
//        File f = new File(path);
//        if(!f.exists()) {
//        	f.mkdir();
//        }
//        
//        try {
//			Files.copy(image.getInputStream(), Paths.get(filepath));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        return name;
//	}


	
	
	
	

}
