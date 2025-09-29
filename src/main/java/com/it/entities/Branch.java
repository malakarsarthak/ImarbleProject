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
public class Branch
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "BranchId")
   private Integer branchId;
   
   @Column(name = "Name", nullable = false)
   private String name;
   
   @Column(name = "Address", nullable = false, unique = true)
   private String address;
   
   @Column(name = "Mobile", nullable = false, unique = true)
   private String mobile;
   
   @Column(name = "Status", nullable = false)
   private boolean status;
   
   @OneToMany(mappedBy = "branch")
   private List<Staff> staff;
   
   @OneToMany(mappedBy = "branchid")
   private List<Sales> sales;
}
