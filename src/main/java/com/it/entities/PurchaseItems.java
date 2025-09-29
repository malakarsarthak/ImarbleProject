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
public class PurchaseItems 
{  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name  = "ItemId")
   private Integer itemId;
   
   @ManyToOne()
   @JoinColumn(name = "ProductId")
   private Product productId;
   
   @ManyToOne()
   @JoinColumn(name = "PurchaseId", nullable = false)
   private Purchase purchaseId;
     
   @Column(name = "Quantity", nullable = false)
   private Integer quantity;
   
   @Column(name = "Amount", nullable = false)
   private Float amount;
}
