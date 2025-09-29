package com.it.entities;

import java.time.LocalDate;

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
public class StaffAdvanced 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "SalaryId")
   private Integer salaryId;
   
   @ManyToOne()
   @JoinColumn(name = "staffid", nullable = false)
   private Staff staff;
   
   @Column(name = "Month", nullable = false)
   private LocalDate month;
   
   @Column(name = "Year", nullable = false)
   private LocalDate year;
   
   @Column(name = "PaymentDate", nullable = false)
   private LocalDate paymentDate;
   
   @Column(name = "Amount", nullable = false)
   private Float amount;
   
   @Column(name = "Mode", nullable = false)
   private String mode;
}
