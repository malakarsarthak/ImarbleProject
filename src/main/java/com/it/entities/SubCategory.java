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
public class SubCategory
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SubCategoryId")
  private Integer subCatId;
  
  @Column(name = "Title", nullable = false)
  private String title;
  
  @Column(name = "Description", nullable = false)
  private String description;
 
  @ManyToOne
  @JoinColumn(name = "categoryid", nullable = false)
  private CategoryId categoryId;
  
  @Column(name = "Image", nullable = false)
  private String image;
  
  @Column(name = "Status", nullable = false)
  private boolean status;
  
  @OneToMany(mappedBy = "subCategory")
  private List<Product> products;
}
