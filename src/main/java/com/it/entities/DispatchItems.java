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
public class DispatchItems 
{  
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name  = "DispatchItemId")
   private Integer DispatchItemId;
   
   @ManyToOne()
   @JoinColumn(name = "DispatchId", nullable = false)
   private SalesDispatch dispatchid;
   
   @ManyToOne()
   @JoinColumn(name = "SalesId", nullable = false)
   private Sales salesid;
     
   @Column(name = "Quantity", nullable = false)
   private Integer quantity;
}
