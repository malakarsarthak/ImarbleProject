package com.it.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CategoryId
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CategoryId")
  private Integer catId;
  
  @Column(name = "Title", nullable = false)
  private String title;
  
  @Column(name = "Description", nullable = false)
  private String description;
  
  @Column(name = "Image", nullable = true)
  private String image;
  
  @Column(name = "Status", nullable = false)
  private boolean status;
  
  @OneToMany(mappedBy = "categoryId")
  private List<SubCategory> subcategories;
  
  @OneToMany(mappedBy = "categoryId")
  private List<Product> products;
}
