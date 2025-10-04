package com.it.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseModel
{
   private Integer userId;
   private String name;
   private String mobile;
   private String role;
   private boolean status;
   private String message;
   private String token;
   
   public LoginResponseModel(String role, String token) {
	super();
	this.role = role;
	this.token = token;
   }
}
