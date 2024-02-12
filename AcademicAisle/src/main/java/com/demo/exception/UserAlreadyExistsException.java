package com.demo.exception;

public class UserAlreadyExistsException extends Exception {
	
	
	String email;

	public UserAlreadyExistsException(String email) {
		super(String.format("%s not found with %s : %1", email));
		this.email = email;
	}
	
	

}
