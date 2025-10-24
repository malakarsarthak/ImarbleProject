package com.it.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entities.DispatchItems;
import com.it.entities.Sales;
import com.it.entities.SalesDispatch;
import com.it.entities.Staff;
import com.it.models.DispatchItemRequestModel;
import com.it.models.SalesDispatchRequestModel;
import com.it.repository.DispatchItemRepository;
import com.it.repository.SalesDispatchRepository;
import com.it.repository.SalesRepository;
import com.it.utils.ApiResponse;

@Service
public class DispatchItemService 
{
   @Autowired
   private DispatchItemRepository dispatchItemRepository;
   
   @Autowired
   private SalesDispatchRepository dispatchRepository;
   
   @Autowired
   private SalesRepository salesRepository;
   
   //Add Dispatch Item
   public ApiResponse addDispatchItem(DispatchItemRequestModel model)
   {
	   try 
	   {
		   Optional<SalesDispatch> opDispatch = dispatchRepository.findById(model.getDispatchid());
           if (opDispatch.isEmpty())
               return new ApiResponse(false, "Dispatch Id Not Found", null);

           Optional<Sales> opSales = salesRepository.findById(model.getSalesid());
           if (opSales.isEmpty())
               return new ApiResponse(false, "Sales Id Not Found", null);

           DispatchItems di = new DispatchItems();
           di.setDispatchid(opDispatch.get());
           di.setSalesid(opSales.get());
           di.setQuantity(model.getQuantity());

           dispatchItemRepository.save(di);
           return new ApiResponse(true, "Dispatch Item Added Successfully", null);
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Update Dispatch Items
   public ApiResponse updateDispatchItems(Integer id, DispatchItemRequestModel model)
   {
	   try 
	   {
		   Optional<DispatchItems> opdispatch = dispatchItemRepository.findById(id);
		   if(opdispatch.isPresent())
		   {
			   DispatchItems dispatch = new DispatchItems();
			   dispatch.setQuantity(model.getQuantity());

			   Optional<SalesDispatch> opsale = dispatchRepository.findById(model.getDispatchid());
			   if(opsale.isEmpty())
			   {
				   return new ApiResponse(false,"Sales dispatch Record Not Found !",null);
			   }
			   dispatch.setDispatchid(opsale.get());

			   Optional<Sales> sales = salesRepository.findById(model.getSalesid());
			   if(sales.isEmpty())
			   {
				   return new ApiResponse(false,"Sales Record Not Found !");
			   }
			   dispatch.setSalesid(sales.get());

			   dispatchItemRepository.save(dispatch);
			   return new ApiResponse(true,"Dispatch Items Update Successfully !",null);
		   }
		   else
		   {
			   return new ApiResponse(false,"Dispatch Items Not Found !");
		   }
	   }
	   catch(Exception e)
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Get Dispatch Item By Id
   public ApiResponse getDispatchItemById(Integer id)
   {
	   try 
	   {
		   Optional<DispatchItems> itemOptional= dispatchItemRepository.findById(id);
		   if(itemOptional.isPresent())
		   {
			   return new ApiResponse(true,"Dispatch Item Found..",itemOptional.get());
		   }
		   else
		   {
			   return new ApiResponse(false,"Dispatch Item Not Found..",null);
		   }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //Get All
   public ApiResponse DispatchItemGetAll()
   {
	   try
	   {
		   List<DispatchItems> list = dispatchItemRepository.findAll();
		   if(list.isEmpty())
		   {
			   return new ApiResponse(false,"Dispatch Item Not Found !",null);
		   }
		   else
		   {
			   return new ApiResponse(true,"Dispatch Item List Found",list);
		   }
	   } 
	   catch (Exception e) 
	   {
		   return new ApiResponse(true,"Error",e.getMessage());
	   }
   }
   
   //Delete Dispatch Items
   public ApiResponse deleteDispatchItem(Integer id)
   {
	   try 
	   {
		   Optional<DispatchItems> op = dispatchItemRepository.findById(id);
		   if(op.isEmpty())
		   {
			   return new ApiResponse(false,"Dispatch Item Not Found!",null);
		   }
		   dispatchItemRepository.delete(op.get());
		   return new ApiResponse(true,"Dispatch Item Deleted Successfully",null);
	   } 
	   catch (Exception e) 	
	   {
		   return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
}
