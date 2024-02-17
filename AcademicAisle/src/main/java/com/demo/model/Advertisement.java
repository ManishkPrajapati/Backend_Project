package com.demo.model;

import java.time.LocalDateTime;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.lang.Long;


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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;
    private Long previewImageId;
    
    @PrePersist
    private void onCreate() { postDate = LocalDateTime.now(); }
    
    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }

	
    
}

