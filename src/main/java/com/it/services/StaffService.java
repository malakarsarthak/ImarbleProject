package com.it.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.entities.Branch;
import com.it.entities.Staff;
import com.it.entities.User;
import com.it.models.StaffRequestModel;
import com.it.repository.BranchRepository;
import com.it.repository.StaffRepository;
import com.it.repository.UserRepository;
import com.it.utils.ApiResponse;



@Service
public class StaffService 
{
  @Autowired
  private StaffRepository staffRepository;
  
  @Autowired
  private  BranchRepository branchRepository;
  
  @Autowired
  private UserRepository userRepository;

  //Add  Staff
  public ApiResponse addStaff(StaffRequestModel model)
  {
	  //Mobile No Same
	  try 
	  {
		  Optional<Staff> staffExist = staffRepository.findByMobile(model.getMobile());
		  if(staffExist.isPresent())
		  {
			  return new ApiResponse(false,"Mobile Number is Already Exist",null);
		  }
		  
		  Optional<User> opUser = userRepository.findById(model.getUserId());
		  if(opUser.isEmpty())
		  {
			  return new ApiResponse(false,"User Id Not Found",null);
		  }
		  
		  Optional<Branch> opBranch = branchRepository.findById(model.getBranchId());
		  if(opBranch.isEmpty())
		  {
			  return new ApiResponse(false,"Branch Id Not Found",null);
		  }
		  
		  Staff staff = new Staff();
		  staff.setName(model.getName());
		  staff.setAddress(model.getAddress());
		  staff.setMobile(model.getMobile());
		  staff.setJoiningDate(model.getJoiningDate());
		  staff.setLeavingDate(model.getLeavingDate());
		  staff.setType(model.getType());
		  staff.setSalaryType(model.getSalaryType());
		  staff.setBaseSalary(model.getBaseSalary());
		  staff.setUserId(opUser.get());
		  staff.setBranchId(opBranch.get());
		  
		  staffRepository.save(staff);
		  return new ApiResponse(true,"Staff Added Successfully !",null);
	  } 
	  catch (Exception e) 
	  {
		 return new ApiResponse(false,"Error",e.getMessage());
   	  }
  }
  
  //Update Staff
  public ApiResponse updateStaff(Integer id,StaffRequestModel model)
  {
	  try 
	  {
		Optional<Staff> opStaff = staffRepository.findById(id);
		if(opStaff.isPresent()) 
		{
			Staff staff = opStaff.get();
			staff.setName(model.getName());
			staff.setAddress(model.getAddress());
			staff.setMobile(model.getMobile());
			staff.setJoiningDate(model.getJoiningDate());
			staff.setLeavingDate(model.getLeavingDate());
			staff.setType(model.getType());
			staff.setSalaryType(model.getSalaryType());
			staff.setBaseSalary(model.getBaseSalary());
			
			Optional<User> opUser = userRepository.findById(model.getUserId());
			if(opUser.isEmpty())
			{
				return new ApiResponse(false,"User Id Not Found",null);
			}
            staff.setUserId(opUser.get());
            
			Optional<Branch> opBranch = branchRepository.findById(model.getBranchId());
			if(opBranch.isEmpty())
			{
				return new ApiResponse(false,"Branch Id Not Found",null);
			}
            staff.setBranchId(opBranch.get());
            
			staffRepository.save(staff);
			return new ApiResponse(true,"Staff Update Successfully !", null);
		}
		else
		{
			return new ApiResponse(false,"Staff Not Found !",null);
		}
	  } 
	  catch (Exception e) 
	  {
		  return new ApiResponse(false,"Error",e.getMessage());
	  }
  }
  
  //Get Staff By Id
  public ApiResponse getStaffById(Integer id)
  {
	  try 
	  {
		Optional<Staff> opStaffById = staffRepository.findById(id);
		if(opStaffById.isPresent()) 
		{
		    return new ApiResponse(true,"Staff Fetched Successfully",opStaffById.get());
		}
		else
		{
			return new ApiResponse(false,"Staff Not Found !",null);
		}
	  } 
	  catch (Exception e) 
	  {
		  return new ApiResponse(false,"Error",e.getMessage());
	  }
  }
  
  //Get All Staff 
  public ApiResponse getAllStaff()
  {
	  try 
	  {
		List<Staff> listStaff = staffRepository.findAll();
		if(listStaff.isEmpty())
		{
			return new ApiResponse(false,"Not Staff Found",null);
		}
		return new ApiResponse(true,"Staff list fetched Successfully !",listStaff);
	  } 
	  catch (Exception e) 
	  {
		  return new ApiResponse(false,"Error",e.getMessage());
	  }
  }
  
  //Delete Staff
  public ApiResponse deleteStaffById(Integer id)
  {
	  try 
	  {
		Optional<Staff> op = staffRepository.findById(id);
		if(op.isPresent()) 
		{
			Staff st = op.get();
			
			st.setBranchId(null);
			st.setUserId(null);
			staffRepository.save(st);
			staffRepository.deleteById(id);
			
			return new ApiResponse(true,"Staff Deleted!",null);
		}
		else
		{
			return new ApiResponse(false,"Staff Not Found !",null);
		}
	  } 
	  catch (Exception e) 
	  {
		  return new ApiResponse(false,"Error",e.getMessage());
	  }
  }
}
