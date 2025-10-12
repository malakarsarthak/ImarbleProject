package com.it.controllers;

import com.it.services.BranchService;
import com.it.utils.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.models.BranchRequestModel;

@RestController
@RequestMapping("/branch")
@CrossOrigin(origins = "")//for Frontend
public class BranchController 
{   
    @Autowired
    private BranchService branchService;
    
    //Add Branch
    @PostMapping("/add")
    public ApiResponse addBranch(@Valid @RequestBody BranchRequestModel model)
    {
    	return branchService.addBranch(model);
    }
    
    //Update Branch
    @PutMapping("/update/{id}")
    public ApiResponse updateBranch(@Valid @RequestBody BranchRequestModel model, @PathVariable Integer id)
    {
    	return branchService.updateBranch(id, model);
    }
    
    //Get Branch
    @GetMapping("/getAll")
    public ApiResponse getBranches()
    {
    	return branchService.getAll();
    }
    
    //Get Branch By Id
    @GetMapping("/get/{id}")
    public ApiResponse getBranchById(@PathVariable Integer id)
    {
    	return branchService.getAllBranchById(id);
    }
    
    //Delete Branch By Id
    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteBranchById(@PathVariable Integer id)
    {
    	return branchService.deleteBranchById(id);
    }
}
