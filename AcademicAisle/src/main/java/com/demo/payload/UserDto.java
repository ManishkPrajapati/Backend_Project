package com.demo.payload;


import com.demo.model.Area;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter 
public class UserDto {
	   
	    private int id;

	    private Area area;

	    
	    private String firstName;

	 
	    private String lastName;

	   
	    private String phone;

	
	    private String email;

	   
	    private String password;


		public UserDto(int id, Area area, String firstName, String lastName, String phone, String email,
				String password) {
			super();
			this.id = id;
			this.area = area;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.password = password;
		}
		
		
		public UserDto( Area area, String firstName, String lastName, String phone, String email,
				String password) {
			super();
			this.area = area;
			this.firstName = firstName;
			this.lastName = lastName;
			this.phone = phone;
			this.email = email;
			this.password = password;
		}
	    
	    
	    
}
