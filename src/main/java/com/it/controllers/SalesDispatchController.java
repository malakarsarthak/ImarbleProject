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

import com.it.models.SalesDispatchRequestModel;
import com.it.services.SalesDispatchService;
import com.it.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/salesDispatch")
public class SalesDispatchController 
{
   @Autowired
   private SalesDispatchService dispatchService;
	
   //add sales dispatch
   @PostMapping("/add")
   public ApiResponse addSalesDispatch(@Valid @RequestBody SalesDispatchRequestModel model)
   {
	   return dispatchService.addSalesDispatch(model);
   }
   
   //Update Sales Dispatch
   @PutMapping("/update/{id}")
   public ApiResponse updateSalesDispatch(@Valid @RequestBody SalesDispatchRequestModel model, @PathVariable Integer id)
   {
	   return dispatchService.updateSalesDispatch(id, model);
   }
   
   //Get Sales Dispatch By Id
   @GetMapping("/get/{id}")
   public ApiResponse salesDispatchById(@PathVariable Integer id)
   {
	   return dispatchService.getSalesDispatchById(id);
   }
   
   //Get All Sales Dispatch 
   @GetMapping("/getAll")
   public ApiResponse salesDispatch()
   {
	   return dispatchService.salesDispatchGetAll();
   }
   
   //Delete Sales Dispatch
   @DeleteMapping("/delete/{id}")
   public ApiResponse deleteSalesDispatch(@PathVariable Integer id)
   {
	   return dispatchService.deleteSalesDispatch(id);
   }
}
