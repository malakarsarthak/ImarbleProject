package com.it.entities;

import java.time.LocalDate;
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
@Entity
@Data
public class Purchase 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "PurchaseId")
   private Integer purchaseId;
   
   @ManyToOne()
   @JoinColumn(name = "ClientId")
   private Client clientId;
   
   @Column(name = "BillAmount", nullable = false)
   private Float billAmount ;
   
   @Column(name = "InvoiceNumber", nullable = false)
   private Integer invoiceNumber;
   
   @Column(name = "PurchaseDate", nullable = false)
   private LocalDate purchaseDate;
   
   @OneToMany(mappedBy = "purchaseId")
   private List<PurchaseItems> items;
}
