package com.it.models;


import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestModel 
{
  @NotNull(message = "User Name Not Null")
  @NotEmpty(message = "User Name Not Empty")
  private String name;
  
  @NotNull(message = "Mobile Number Not Null")
  @NotEmpty(message = "Moblie Nummber Not Empty")
  @Length(min = 10,max = 10, message = "Wrong Mobile Number")
  private String mobile;
  
  @NotNull(message = "Password Not Null")
  @NotEmpty(message = "Password Not Empty")
  private String password;
  
  @NotNull(message = "Role Not Null")
  @NotEmpty(message = "Role  Not Empty")
  private String role;
}
