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
@Data
@Entity
public class Sales 
{
  @Id
  @GeneratedValue(strategy =  GenerationType.IDENTITY)
  @Column(name = "SalesId")
  private Integer salesId;
  
  @ManyToOne()
  @JoinColumn(name = "clientId", nullable = false)
  private Client clientid;
  
  @Column(name = "SalesType", nullable = false)
  private String Salestype;
  
  @Column(name = "SalesDate", nullable = false)
  private LocalDate salesDate;
  
  @Column(name = "BillAmount", nullable = false)
  private Float billAmount;
  
  @ManyToOne()
  @JoinColumn(name = "BranchId", nullable = false)
  private Branch branchid;
  
  @Column(name = "InvoiceNumber", nullable = false)
  private String invoiceNumber;
  
  @Column(name = "Status", nullable = false)
  private boolean status;
  
  @OneToMany(mappedBy = "salesid")
  private List<SalesItems> salesItems;
  
  @OneToMany(mappedBy = "salesid")
  private List<DispatchItems> dispatchItems;
}
