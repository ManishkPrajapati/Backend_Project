package com.demo.payload;

import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	private String categoryTitle;
	
	
}