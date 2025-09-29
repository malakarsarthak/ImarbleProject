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
public class StockTracker 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TrackId")
  private Integer trackId;
  
  @ManyToOne()
  @JoinColumn(name = "ProductId", nullable = false)
  private Product productid;
  
  @Column(name = "StockType", nullable = false)
  private String StockType;
  
  @Column(name = "ReferenceId", nullable = false)
  private String referenceId;
  
  @Column(name = "Quantity", nullable = false)
  private String quantity;
  
  @Column(name = "Status", nullable = false)
  private boolean status;
}
