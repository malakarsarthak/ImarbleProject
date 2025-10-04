package com.it.controllers;

import java.util.List;
import java.util.Optional;

import com.it.repository.BranchRepository;


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

import com.it.entities.Branch;

@RestController
@RequestMapping("/branch")
@CrossOrigin(origins = "")//for Frontend
public class BranchController 
{

  
    @Autowired
    private BranchRepository  branchRepository;

    BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
    
    //Get Branch
    @GetMapping
    public List<Branch> getBranches()
    {
    	return branchRepository.findAll();
    }
    
    //Get Branch By Id
    @GetMapping("/{id}")
    public Optional<Branch> getBranchById(@PathVariable Integer id)
    {
    	return branchRepository.findById(id);
    }
    
    //Add Branch
    @PostMapping
    public Branch addBranch(@RequestBody Branch branch)
    {
    	return branchRepository.save(branch);
    }

    //Update Branch
    @PutMapping("/{id}")
    public Branch updateBranch(@PathVariable Integer id, @RequestBody Branch branch)
    {
        Optional<Branch> op = branchRepository.findById(id);
        if(op.isPresent())
        {
        	Branch br = op.get();
        	br.setName(branch.getName());
        	br.setAddress(branch.getAddress());
        	br.setMobile(branch.getMobile());
        	br.setStatus(branch.isStatus());
        	return branchRepository.save(br);
        }
        else
        {
        	return null;
        }
    }
    
    @DeleteMapping("/{id}")
    public String deleteBranch(@PathVariable Integer id)
    {
    	Optional<Branch> op = branchRepository.findById(id);
    	if(op.isPresent())
    	{
    		branchRepository.deleteById(id);
    		return "Branch deleted successfully and its id is " + id;
    	}
    	else
    	{
    		return "Branch Not Found";
    	}
    }
}
