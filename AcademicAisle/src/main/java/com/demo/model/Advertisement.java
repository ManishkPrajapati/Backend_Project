package com.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Advertisement")
@NoArgsConstructor
@Getter
@Setter
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private Category category;



    @Column(name = "Adv_title")
    private String title;

    @Column(name = "Post_date")
    private LocalDateTime postDate;


    @Column(name = "P_Description")
    private String pDescription;



    @Column(name = "P_Condition")
    private String pCondition;

    @Column(name = "Price")
    private double price;
    

    
    private String area;
    
    private String image1;
    
    private String image2;
    
    private String image3;
    
    
    @ManyToOne
    @JoinColumn
    private User user;
    
    @PrePersist
    private void onCreate() { postDate = LocalDateTime.now(); }

	@Override
	public String toString() {
		return "Advertisement [id=" + id + ", category=" + category + ", title=" + title + ", postDate=" + postDate
				+ ", pDescription=" + pDescription + ", pCondition=" + pCondition + ", price=" + price + ", area="
				+ area + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", user=" + user + "]";
	}
    

	
    
}