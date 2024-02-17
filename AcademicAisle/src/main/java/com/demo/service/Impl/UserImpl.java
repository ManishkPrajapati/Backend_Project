package com.demo.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Area;
import com.demo.model.User;
import com.demo.payload.UserDto;
import com.demo.repository.AreaRepo;
import com.demo.repository.UserRepo;
import com.demo.service.UserService;
import com.demo.exception.*;


@Service
public class UserImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AreaRepo areaRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		
		User user;
		User saveUser = null;
		try {
			user = this.dtoToUser(userDto);
			 saveUser = this.userRepo.save(user);
			
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		
		 Area area = areaRepo.findByAreaName(userDto.getArea().getArea());

	        // If area not found, create and save a new area
	        if (area == null) {
	            area = new Area();
	            area.setArea(userDto.getArea().getArea());
	            area.setCity(userDto.getArea().getCity());
	            area.setState(userDto.getArea().getState());
	            area.setCountry(userDto.getArea().getCountry());
	            area = areaRepo.save(area); // Save and get the managed entity
	        }
		
		
		user.setArea(area);
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userToDto1 = this.userToDto(updatedUser);
		return userToDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		this.userRepo.delete(user);

	}
	
    public User dtoToUser(UserDto userDto) throws UserAlreadyExistsException {
        // Check if the user already exists
       
        
//        User u = this.userRepo.existsByEmail(userDto.getEmail());
//        if(u != null) {
//        	throw new UserAlreadyExistsException("User already exists with email: " + userDto.getEmail());
//        }


        // Check if the area exists in the database
        Area area = areaRepo.findByAreaName(userDto.getArea().getArea());
        

        // If area not found, create and save a new area
        if (area == null) {
        	area = modelMapper.map(userDto.getArea(), Area.class);
            area = areaRepo.save(area); // Save and get the managed entity
        }
        
        User user = modelMapper.map(userDto, User.class);

        // Set the area to the user
        user.setArea(area);

        // Save the user
        return userRepo.save(user);
    }
	
	public UserDto userToDto(User user) {		
		Area areaDto = this.modelMapper.map(user.getArea(), Area.class);
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		userDto.setArea(areaDto);		
		return userDto;
	}

}
