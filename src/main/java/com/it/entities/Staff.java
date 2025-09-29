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
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Staff 

{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "StaffId")
  private Integer staffId;
  
  @Column(name = "Name", nullable = false)
  private String name;
  
  @Column(name = "Address", nullable = false, unique = true)
  private String address;
  
  @Column(name = "Mobile", nullable = false, unique = true)
  private String mobile;
  
  @Column(name="JoiningDate", nullable = false)
  private LocalDate joiningDate;
  
  @Column(name="LeavingDate", nullable = false)
  private LocalDate LeavingDate;
  
  @Column(name="Type", nullable = false)
  private String type;

  @Column(name="SalaryType", nullable = false)
  private String salaryType;

  @Column(name="BaseSalary", nullable = false)
  private Float baseSalary;

  @ManyToOne
  @JoinColumn(name = "branchid", nullable = false)
  private Branch branch;
  
  @OneToOne
  @JoinColumn(name = "userid", nullable = false)
  private User user;
  
  @OneToMany(mappedBy = "staff")
  private List<StaffAttendance> satffAttendance;
  
  @OneToMany(mappedBy = "staff")
  private List<StaffSalary> staffSalary;
  
  @OneToMany(mappedBy = "staff")
  private List<StaffAdvanced> staffAdvanced;
  
  @OneToMany(mappedBy = "dispatcher")
  private List<SalesDispatch> salesDispatchs;
}
