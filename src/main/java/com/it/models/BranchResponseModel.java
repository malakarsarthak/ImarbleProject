package com.it.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BranchResponseModel 
{
   private Integer branchid;
   private String name;
   private String address;
   private String mobile;
   private boolean status;
}
