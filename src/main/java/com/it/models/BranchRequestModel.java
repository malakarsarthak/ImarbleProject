package com.it.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchRequestModel 
{
   @NotNull(message = "Branch Name Not Null")
   @NotEmpty(message = "Branch Name Not Empty")
   private String name;
   
   @NotNull(message = "Branch address Not Null")
   @NotEmpty(message = "Branch address Not Empty")
   private String address;
   
   @NotNull(message = "Branch mobile Not Null")
   @NotEmpty(message = "Branch mobile Not Empty")
   private String mobile;
   
   @NotNull(message = "Branch status Not Null")
   private boolean status;

}
