package com.it.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffResponseModel 
{
   private String name;
   private String mobile;
   private String address;
   private String type;
   private String salaryType;
   private Float  baseSalary;
   private LocalDate joiningDate;
   private LocalDate leavingDate;
   private String userName;
   private String branchName;
}
