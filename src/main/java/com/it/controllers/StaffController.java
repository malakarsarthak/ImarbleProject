package com.it.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entities.Staff;
import com.it.repository.StaffRepository;

@RestController
@RequestMapping("/staffs")
public class StaffController
{
   @Autowired
   private StaffRepository staffRepository;
   
   //Get All Staff
   @GetMapping
   public List<Staff> getAllStaffs()
   {
	   return staffRepository.findAll();
   }
   
   //Get Staff By Id
   @GetMapping("/{id}")
   public Optional<Staff> getStaffById(@PathVariable Integer id)
   {
	  return staffRepository.findById(id);
   }
   
   //Add Staff
   @PostMapping()
   public Staff addStaff(@RequestBody Staff staff)
   {
	   return staffRepository.save(staff);
   }
   
   //Update Staff
   @PutMapping("/{id}")
   public Staff updateStaff(@RequestBody Staff staff,@PathVariable Integer id)
   {
	   Optional<Staff> op = staffRepository.findById(id);
	   if(op.isPresent())
	   {
		   Staff st = op.get();
		   st.setName(staff.getName());
		   st.setAddress(staff.getAddress());
		   st.setMobile(staff.getMobile());
		   st.setJoiningDate(staff.getJoiningDate());
		   st.setLeavingDate(staff.getLeavingDate());
		   st.setType(staff.getType());
		   st.setSalaryType(staff.getSalaryType());
		   st.setBaseSalary(staff.getBaseSalary());
		   
		   if (staff.getBranch() != null && staff.getBranch().getBranchId() != null) {
			   st.setBranch(staff.getBranch());
		   }
		   if(staff.getUser() != null && staff.getUser().getUserId() != null)
		   {
			   st.setUser(staff.getUser());
           }
		   return staffRepository.save(st);
	   }
	   else
	   {
		   return null;
	   }
   }
   
   @DeleteMapping("/{id}")
   public String deleteStaff(@PathVariable Integer id)
   {
	  Optional<Staff> op = staffRepository.findById(id);
	  if(op.isPresent())
	  {
		  staffRepository.deleteById(id);
		  return "Staff is deleted and its id is " + id;
	  }
	  else
	  {
		  return "Staff Not Found";
	  }
   }
}
