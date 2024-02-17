package com.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email", unique = true)
    private String email;
    
    private boolean active;
    
    private String activationCode;
    
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "Area_id")
    private Area area;
    
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
//            mappedBy = "user")
//    private List<Advertisement> products = new ArrayList<>();
//
//    public void addProductToUser(Advertisement product) {
//        product.setUser(this);
//        products.add(product);
//    }

   
}
