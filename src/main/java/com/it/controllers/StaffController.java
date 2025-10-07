package com.it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.models.StaffRequestModel;
import com.it.services.StaffService;
import com.it.utils.ApiResponse;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/staffs")
public class StaffController
{
   @Autowired
   private StaffService staffService;
   
   //Add Staff
   @PostMapping("/add")
   public ApiResponse addStaff(@Valid @RequestBody StaffRequestModel model)
   {
	   return staffService.addStaff(model);
   }
   
   //Update Staff
   @PutMapping("/update/{id}")
   public ApiResponse updateStaff(@Valid @RequestBody StaffRequestModel model,@PathVariable Integer id)
   {
	   return staffService.updateStaff(id, model);
   }
   
   //Get Staff By Id
   @GetMapping("/get/{id}")
   public ApiResponse getStaffById(@PathVariable Integer id)
   {
	   return staffService.getStaffById(id);
   }
   
   //Get All Staff
   @GetMapping("/getAll")
   public ApiResponse getAllStaff()
   {
	   return staffService.getAllStaff();
   }
   
   @DeleteMapping("/delete/{id}")
   public ApiResponse deleteStaffById(@PathVariable Integer id)
   {
	 return staffService.deleteStaffById(id);
   }
}
