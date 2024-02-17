//package com.demo.model;
//
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@AllArgsConstructor
//@Getter
//@Setter
//@Table(name="wishlist")
//public class WishList {
//
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne
//	@JoinColumn(name = "product_id")
//	private Advertisement product;
//	
//}
//
