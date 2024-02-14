package com.demo.model;


import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Advertisement")
@NoArgsConstructor
@Getter
@Setter
public class Advertisment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "Vendor_id")
//    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;

    @Column(name = "Verification_Status")
    private String verificationStatus;

    @Column(name = "Adv_title")
    private String advTitle;
    
    @CreationTimestamp
    @Column(name = "Post_date", nullable = false, updatable = false)
    private Date postDate;

    @Column(name = "Image")
    private String image;

    @Column(name = "P_Description")
    private String pDescription;

    @Column(name = "Is_active")
    private String isActive;

    @Column(name = "P_Condition")
    private String pCondition;

    @Column(name = "Price")
    private double price;

    // Getters and setters
}

