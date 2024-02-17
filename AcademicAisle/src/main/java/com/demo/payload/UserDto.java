package com.demo.payload;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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

	    @NotEmpty(message = "should be min 3 characters ")
	    private String firstName;

	    @NotEmpty (message = "should be min 3 characters ")
	    private String lastName;

	    @NotEmpty
	    private String phone;

	    @Email
	    private String email;

	    @NotEmpty(message = "should be min 8 characters ")
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
