package com.it.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entities.Sales;
import com.it.entities.SalesDispatch;
import com.it.entities.Staff;
import com.it.models.SalesDispatchRequestModel;
import com.it.repository.SalesDispatchRepository;
import com.it.repository.SalesRepository;
import com.it.repository.StaffRepository;
import com.it.utils.ApiResponse;

@Service
public class SalesDispatchService 
{
   @Autowired
   private SalesDispatchRepository dispatchRepository;
   
   @Autowired
   private StaffRepository staffRepository;
   
   @Autowired
   private SalesRepository salesRepository;
   
   //Add Sales Dispatch
   public ApiResponse addSalesDispatch(SalesDispatchRequestModel model)
   {
	   try 
	   {
		  Optional<Staff> staff = staffRepository.findById(model.getDispatcher());
		  if(staff.isEmpty())
		  {
			  return new ApiResponse(false,"Staff Not  Found",null);
		  }
		  
		  Optional<Sales> sales = salesRepository.findById(model.getSales());
		  if(sales.isEmpty())
		  {
			  return new ApiResponse(false,"Sales Record Not Found",null);
		  }
		  
		  SalesDispatch dispatch = new SalesDispatch();
		  dispatch.setDispatchDate(model.getDispatchDate());
		  dispatch.setSales(sales.get());
		  dispatch.setDispatcher(staff.get());
		  
		  dispatchRepository.save(dispatch);
		  return new ApiResponse(true,"Sales dispatch added Sucessfully !",null);
	   }  
	   catch (Exception e) 
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Update Sales Dispatch
   public ApiResponse updateSalesDispatch(Integer id, SalesDispatchRequestModel model)
   {
	   try 
	   {
		  Optional<SalesDispatch> opsales = dispatchRepository.findById(id);
		  if(opsales.isPresent())
		  {
			  SalesDispatch dispatch = new SalesDispatch();
			  dispatch.setDispatchDate(model.getDispatchDate());
			  
			  Optional<Staff> opstaff = staffRepository.findById(model.getDispatcher());
			  if(opstaff.isEmpty())
			  {
				  return new ApiResponse(false,"Staff Not Found !",null);
			  }
			  dispatch.setDispatcher(opstaff.get());
			  
			  Optional<Sales> sales = salesRepository.findById(model.getSales());
			  if(sales.isEmpty())
			  {
				  return new ApiResponse(false,"Sales Record Not Found !");
			  }
			  dispatch.setSales(sales.get());
			  
			  dispatchRepository.save(dispatch);
			  return new ApiResponse(true,"Sales Dispatch Update Successfully !",null);
		  }
		  else
		  {
			  return new ApiResponse(false,"Sales Dispatch Not Found !");
		  }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Get Sales Dispatch By Id
   public ApiResponse getSalesDispatchById(Integer id)
   {
	   try 
	   {
		   Optional<SalesDispatch> salesdispatch = dispatchRepository.findById(id);
		   if(salesdispatch.isPresent())
		   {
			   return new ApiResponse(true,"Sales Dispatch Found..",salesdispatch.get());
		   }
		   else
		   {
			   return new ApiResponse(false,"Sales Dispatch Not Found..",null);
		   }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Get All
   public ApiResponse salesDispatchGetAll()
   {
	   try
	   {
		   List<SalesDispatch> list = dispatchRepository.findAll();
		   if(list.isEmpty())
		   {
			   return new ApiResponse(false,"Sales Dispatch Not Found !",null);
		   }
		   else
		   {
			   return new ApiResponse(true,"Sales Dispatch List Found",list);
		   }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(true,"Error",e.getMessage());
	   }
   }
   
   //Delete Sales Dispatch
   public ApiResponse deleteSalesDispatch(Integer id)
   {
	   try 
	   {
		   Optional<SalesDispatch> op = dispatchRepository.findById(id);
		   if(op.isEmpty())
		   {
			   return new ApiResponse(false,"Sales Dispatch Not Found!",null);
		   }
		   dispatchRepository.delete(op.get());
		   return new ApiResponse(true,"Sales Dispatch Deleted Successfully",null);
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
}
