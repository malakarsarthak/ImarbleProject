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

import com.it.models.SalesRequestModel;
import com.it.services.SalesService;
import com.it.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sales")
public class SalesController 
{
   @Autowired
   private SalesService salesService;
   
   //Add Sales
   @PostMapping("/add")
   public ApiResponse addSales(@Valid @RequestBody SalesRequestModel model)
   {
	   return salesService.addSales(model);
   }
   
   //Update Sales
   @PutMapping("/update/{id}")
   public ApiResponse updateSales(@Valid @RequestBody SalesRequestModel model,@PathVariable Integer id)
   {
	   return salesService.updateSales(id, model);
   }
   
   //Get Sales By Id
   @GetMapping("/get/{id}")
   public ApiResponse getSalesById(@PathVariable Integer id)
   {
	   return salesService.getSalesById(id);
   }
   
   //Get All Sales
   @GetMapping("/getAll")
   public ApiResponse getAllSales()
   {
	   return salesService.salesGetAll();
   }
   
   //Delete Sales
   @DeleteMapping("/delete/{id}")
   public ApiResponse deleteSales(@PathVariable Integer id)
   {
	   return salesService.deleteSales(id);
   }
}
