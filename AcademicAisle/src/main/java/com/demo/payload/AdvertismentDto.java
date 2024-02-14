package com.demo.payload;

import java.util.Date;


import com.demo.model.Category;
import com.demo.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AdvertismentDto {

  
    private int id;

    private User user;


//    private Vendor vendor;

   
    private Category category;

    private String verificationStatus;


    private String advTitle;


    private Date postDate;


    private String image;


    private String pDescription;


    private String isActive;


    private String pCondition;


    private double price;

    // Getters and setters
}

