package com.it.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.models.DispatchItemRequestModel;
import com.it.services.DispatchItemService;
import com.it.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/dispatchitem")
public class DispatchItemController 
{
   @Autowired
   private DispatchItemService dispatchItemService;
    
   //Add Dispatch Item
   @PostMapping("/add")
   public ApiResponse addDispatchItem(@Valid @RequestBody DispatchItemRequestModel model)
   {
	   return dispatchItemService.addDispatchItem(model);
   }
   
   //Update Dispatch Item
   @PutMapping("/update/{id}")
   public ApiResponse updateDispatchItem(@Valid @RequestBody DispatchItemRequestModel model,@PathVariable Integer id)
   {
	   return dispatchItemService.updateDispatchItems(id, model);
   }
   
   //Get Dispatch Item By Id
   @GetMapping("/get/{id}")
   public ApiResponse DispatchItemById(@PathVariable Integer id)
   {
	   return dispatchItemService.getDispatchItemById(id);
   }
   
   //Get All Dispatch Item
   @GetMapping("/getAll")
   public ApiResponse getAllDispatchItem()
   {
	   return dispatchItemService.DispatchItemGetAll();
   }
   
   //Delete Dispatch Item
   @DeleteMapping("/delete/{id}")
   public ApiResponse deleteDispatchItem(@PathVariable Integer id)
   {
	   return dispatchItemService.deleteDispatchItem(id);
   }
}
