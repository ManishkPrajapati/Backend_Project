package com.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MethodArgumentsNotValidException extends RuntimeException{
	
	String fielsName;
	String message;
	public MethodArgumentsNotValidException(String fielsName, String message) {
		super();
		this.fielsName = fielsName;
		this.message = message;
	}
	
	
	
}
