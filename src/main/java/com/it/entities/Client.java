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
public class Client 
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="ClientId")
   private Integer clientId;
   
   @Column(name = "Name", nullable = false)
   private String name;
   
   @Column(name = "Mobile", nullable = false, unique = true)
   private String mobile;
   
   @Column(name = "Email", nullable = false, unique = true)
   private String email;

   @Column(name = "Address", nullable = false, unique = true)
   private String address;
   
   @Column(name = "Type", nullable = false)
   private String type;
   
   @Column(name = "GSTNumber", nullable = false, unique = true) 
   private String gstNumber;
   
   @OneToMany(mappedBy = "clientId")
   private List<Purchase> purchases;
   
   @OneToMany(mappedBy = "clientid")
   private List<Sales> sales;
}