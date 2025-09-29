package com.it.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MissingItem 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MissingId")
  private Integer missingId;
  
  @ManyToOne()
  @JoinColumn(name = "ProductId", nullable = false)
  private Product productid;
  
  @Column(name = "Quantity", nullable = false)
  private String quantity;
  
  @Column(name = "MissingType", nullable = false)
  private String missingType;
  
  @Column(name = "Description", nullable = false)
  private String discription;
}
