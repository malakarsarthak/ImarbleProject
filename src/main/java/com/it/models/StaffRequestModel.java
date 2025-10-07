package com.it.models;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffRequestModel 
{
   @NotNull(message = "Staff Name Not Null")
   @NotEmpty(message= "Staff Name Not Empty")
   private String name;
   
   @NotNull(message = "Staff Mobile Not Null")
   @NotEmpty(message= "Staff Mobile Not Empty")
   @Length(min = 10, max=10, message = "Ivalid Mobile Number !")
   private String mobile;
   
   @NotNull(message = "Staff Address Not Null")
   @NotEmpty(message= "Staff Address Not Empty")
   private String address;
   
   @NotNull(message = "Staff Type Not Null")
   @NotEmpty(message= "Staff Type Not Empty")
   private String type;
   
   @NotNull(message = "Staff Salary Type Not Null")
   @NotEmpty(message= "Staff Salary Type Not Empty")
   private String salaryType;
   
   @NotNull(message = "Staff Base Salary Not Null")
   private Float  baseSalary;
   
   @NotNull(message = "Joining Date Not Null")
   @JsonFormat(pattern = "dd/MM/yyyy") 
   private LocalDate joiningDate;
   
  
   @JsonFormat(pattern = "dd/MM/yyyy") 
   private LocalDate leavingDate;
   
   @NotNull(message = "Staff User Id  Not Null")
   private Integer userId;
   
   @NotNull(message = "Staff Branch Id  Not Null")
   private Integer branchId;
}
