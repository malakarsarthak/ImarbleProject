package com.it.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entities.Branch;
import com.it.entities.Client;
import com.it.entities.Sales;
import com.it.models.SalesRequestModel;
import com.it.repository.BranchRepository;
import com.it.repository.ClientRepository;
import com.it.repository.SalesRepository;
import com.it.utils.ApiResponse;

@Service
public class SalesService 
{
	@Autowired 
	private SalesRepository salesRepository;
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	//Add Sales
    public ApiResponse addSales(SalesRequestModel model)
    {
    	try 
    	{
		   Optional<Client> cl = clientRepository.findById(model.getClientid());
		   if(cl.isEmpty())
		   {
			   return new ApiResponse(false,"Client Id Not Found",null);
		   }
		   
		   Optional<Branch> br = branchRepository.findById(model.getBranchid());
		   if(br.isEmpty())
		   {
			   return new ApiResponse(false,"Branch Id Not Found",null);
		   }
		   
		   Sales sl = new Sales();
		   sl.setClientid(cl.get());
		   sl.setSalestype(model.getSalestype());
		   sl.setSalesDate(model.getSalesDate());
		   sl.setBillAmount(model.getBillAmount());
		   sl.setBranchid(br.get());
		   sl.setInvoiceNumber(model.getInvoiceNumber());
		   sl.setStatus(true);
		   
		   salesRepository.save(sl);
		   return new ApiResponse(true,"Sales Added Successfully !",null);
		} 
    	catch (Exception e) 
    	{
			return new ApiResponse(false,"Error",e.getMessage());
		}
    }

    //Update Sales
    public ApiResponse updateSales(Integer id,SalesRequestModel model)
    {
    	try 
    	{
    		Optional<Sales> sl = salesRepository.findById(id);
        	if(sl.isPresent())
        	{
        	    Sales sales = sl.get(); 
        	    sales.setSalestype(model.getSalestype());
        	    sales.setSalesDate(model.getSalesDate());
        	    sales.setBillAmount(model.getBillAmount());
        	    sales.setInvoiceNumber(model.getInvoiceNumber());
        	    sales.setStatus(true);
        	    
        	    Optional<Client> opClient = clientRepository.findById(model.getClientid());
            	if(opClient.isEmpty())
            	{
            		return new ApiResponse(false,"Client Id Not Found !");
            	}
            	sales.setClientid(opClient.get());
            	
            	Optional<Branch> opBranch = branchRepository.findById(model.getBranchid());
            	if(opBranch.isEmpty())
            	{
            		return new ApiResponse(false,"Branch Id Not Found !");
            	}
            	sales.setBranchid(opBranch.get());
            	
            	salesRepository.save(sales);
            	return new ApiResponse(true,"Sales Update Successfully",null);
        	}
        	else
        	{
        		return new ApiResponse(false,"Sales Not Found !",null);
        	}
		} 
    	catch (Exception e) 
    	{
    		return new ApiResponse(false,"Error",e.getMessage());
		}
    }
    
   //Get Sales By Id
   public ApiResponse getSalesById(Integer id)
   {
	   try 
	   {
		   Optional<Sales> opSales = salesRepository.findById(id);
		   if(opSales.isPresent())
		   {
			   return new ApiResponse(true,"Sales Found..",opSales.get());
		   }
		   else
		   {
			   return new ApiResponse(false,"Sales Not Found..",null);
		   }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Get All
   public ApiResponse salesGetAll()
   {
	   try
	   {
		  List<Sales> list = salesRepository.findAll();
		  if(list.isEmpty())
		  {
			  return new ApiResponse(false,"Sales Not Found !",null);
		  }
		  else
		  {
			  return new ApiResponse(true,"Sales Found",list);
		  }
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(true,"Error",e.getMessage());
	   }
   }
   
   //Delete Sales
   public ApiResponse deleteSales(Integer id)
   {
	   try 
	   {
		  Optional<Sales> op = salesRepository.findById(id);
		  if(op.isEmpty())
		  {
			   return new ApiResponse(false,"Sales Not Found!",null);
		  }
		  salesRepository.delete(op.get());
		  return new ApiResponse(true,"Sales Deleted Successfully",null);
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
}
