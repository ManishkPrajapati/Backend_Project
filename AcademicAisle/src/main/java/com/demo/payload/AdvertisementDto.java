package com.demo.payload;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.demo.model.Category;
import com.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"user"})
public class AdvertisementDto {
	

		private int id;

	    private Category category;

	    private String title;

	    private LocalDateTime postDate;

	    private String pDescription;

	    private String pCondition;

	    private double price;

	    private String area;
	    
	    private User user;
	    
	    private String image1;
	    
	    private String image2;
	    
	    private String image3;

		public AdvertisementDto(int id, Category category, String title, LocalDateTime postDate, String pDescription,
				String pCondition, double price, String area, User user, String image1,
				String image2, String image3) {
			super();
			this.id = id;
			this.category = category;
			this.title = title;
			this.postDate = postDate;
			this.pDescription = pDescription;
			this.pCondition = pCondition;
			this.price = price;
			this.area = area;
			this.user = user;
			this.image1 = image1;
			this.image2 = image2;
			this.image3 = image3;
		}

		@Override
		public String toString() {
			return "AdvertisementDto [id=" + id + ", category=" + category + ", title=" + title + ", postDate="
					+ postDate + ", pDescription=" + pDescription + ", pCondition=" + pCondition + ", price=" + price
					+ ", area=" + area + ", user=" + user + ", image1=" + image1 + ", image2="
					+ image2 + ", image3=" + image3 + "]";
		}
	    
	    
	
}
