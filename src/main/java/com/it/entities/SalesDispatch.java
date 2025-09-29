package com.it.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SalesDispatch 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DispatchId")
  private Integer dispatchId;
  
  @Column(name = "DiapatchDate", nullable = false)
  private LocalDate dispatchDate;
  
  @ManyToOne()
  @JoinColumn(name = "DispatcherId", nullable = false)
  private Staff dispatcher;
  
  @OneToOne()
  @JoinColumn(name = "salesid", nullable = false)
  private Sales sales;
}
