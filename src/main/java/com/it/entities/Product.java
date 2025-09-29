package com.it.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product 
{  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name  = "ProductId")
   private Integer productId;
   
   @ManyToOne()
   @JoinColumn(name = "categoryid")
   private CategoryId categoryId;
   
   @ManyToOne()
   @JoinColumn(name = "subcategoryid")
   private SubCategory subCategory;
   
   @ManyToOne()
   @JoinColumn(name = "brandid")
   private Brand brand;
   
   @Column(name = "ModelNumber", nullable = false)
   private String modelNumber;
   
   @Column(name = "Unit", nullable = false)
   private Float unit;
   
   @Column(name = "Description", nullable = true)
   private String description;
   
   @Column(name = "PricePerUnit", nullable = false)
   private Float priceperUnit;
   
   @Column(name = "Image", nullable = false)
   private String image;
   
   @Column(name = "MinStockLevel", nullable = false)
   private Integer minStockLevel;
   
   @OneToMany(mappedBy = "productId")
   private List<PurchaseItems> items;
   
   @OneToMany(mappedBy = "productId")
   private List<SalesItems> salesItems;
   
   @OneToMany(mappedBy = "productid")
   private List<MissingItem> missingItems;
   
   @OneToMany(mappedBy = "productid")
   private List<StockTracker> stockTrackers;
}
