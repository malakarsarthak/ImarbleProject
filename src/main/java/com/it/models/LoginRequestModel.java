package com.it.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequestModel 
{
  @NotNull(message = "Mobile Number Not Null")
  @NotEmpty(message = "Mobile Number Not Empty")
  private String mobile;
  
  @NotNull(message = "Password Not Null")
  @NotEmpty(message = "Password Not Empty")
  private String password;
}
