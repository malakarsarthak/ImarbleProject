package com.it.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entities.Branch;
import com.it.models.BranchRequestModel;
import com.it.repository.BranchRepository;
import com.it.utils.ApiResponse;


@Service
public class BranchService 
{
   @Autowired
   private BranchRepository branchRepository;
   
   //Add Branch
   public ApiResponse addBranch(BranchRequestModel model)
   {
	  try 
	  {
		Optional<Branch> exist = branchRepository.findByMobile(model.getMobile());
		if(exist.isPresent())
		{
			return new ApiResponse(false,"Mobile number with this branch is already exist",null);
		}
		
		Branch br = new Branch();
		br.setName(model.getName());
		br.setAddress(model.getAddress());
		br.setMobile(model.getMobile());
		br.setStatus(true);
		
		branchRepository.save(br);
		return new ApiResponse(true,"Branch Added SuccessFully",br);
	  }
	  catch (Exception e) 
	  {
		return new ApiResponse(false,"Error",e.getMessage());
	  }   
   }
   
   //Update Branch
   public ApiResponse updateBranch(Integer id,BranchRequestModel model)
   {
	   try 
	   {
		  Optional<Branch> op = branchRepository.findById(id);
		  if(op.isEmpty())
		  {
			  return new ApiResponse(false,"Branch Not Found With id");
		  }
		  
		  Branch br = op.get();
		  br.setName(model.getName());
		  br.setMobile(model.getMobile());
		  br.setAddress(model.getAddress());
		  br.setStatus(true);
		  
		  branchRepository.save(br);
		  return new ApiResponse(true,"Branch Update Successfully",br);
	   } 
	   catch (Exception e) 
	   {
		 return new ApiResponse(false,"Error :",e.getMessage());
	   }
   }
   
   //Get All Branch
   public ApiResponse getAll()
   {
	   try 
	   {
		  List<Branch> listBranch = branchRepository.findAll();
		  if(listBranch.isEmpty()) 
		  {
			return new ApiResponse(false,"List Of Branch is empty",null);  
		  }
		  return new ApiResponse(true,"List of Branch is fetched Successfully",listBranch);
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(true,"Error",e.getMessage());
	   }
   }
   
   //GetAllBranchById
   public ApiResponse getAllBranchById(Integer id)
   {
	   try 
	   {
		 Optional<Branch> op = branchRepository.findById(id);
		 if(op.isPresent())
		 {
			 return new ApiResponse(true,"Branch Fetched Successfully",op.get());
		 }
		 else
		 {
			 return new ApiResponse(false,"Branch Not Found",null);
		 }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Delete BranchById
   public ApiResponse deleteBranchById(Integer id)
   {
	   try
	   {
		 Optional<Branch> op = branchRepository.findById(id);
		 if(op.isPresent())
		 {
			 branchRepository.delete(op.get());
			 return new ApiResponse(true,"Branch Deleted Successfully",null);
		 }
		 else
		 {
			 return new ApiResponse(false,"Branch Not Found",null);
		 }
	   } 
	   catch (Exception e)
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
}
