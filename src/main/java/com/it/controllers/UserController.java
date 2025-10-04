package com.it.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entities.User;
import com.it.models.LoginRequestModel;
import com.it.models.LoginResponseModel;
import com.it.models.RegisterRequestModel;
import com.it.repository.UserRepository;
import com.it.services.UserService;
import com.it.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "")//frontend
public class UserController 
{
   @Autowired
   private UserService userService;
   
   @Autowired
   private UserRepository userRepository;
   
   //Register user
   @PostMapping("/register")
   public ApiResponse registerUser(@Valid @RequestBody RegisterRequestModel model)
   {
	    try 
	    {
            boolean status = userService.registerUser(model);
            if(status)
            {
            	return new ApiResponse(true,"User Register Successfully",null);
            }
            else
            {
            	return new ApiResponse(false,"User Already Registered !");
            }
            
		} 
	    catch (Exception e) 
	    {
			return new ApiResponse(false,"Error",e.getMessage());
		}
   }
   
   //Login User
   @PostMapping("/login")
   public ApiResponse loginUser(@Valid @RequestBody LoginRequestModel model)
   {
	   try 
	   {
		   LoginResponseModel resp = userService.loginUser(model);
		   if(resp != null)
		   {
			   return new ApiResponse(true,"Login Successfully !", resp);
		   }
		   else
		   {
			   return new ApiResponse(false,"Invaild Mobile Or Password !");
		   }
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
   
   //get All User
   @GetMapping("/all")
   public ApiResponse getAllUser()
   {
	   try 
	   {
		  List<User> list = userRepository.findAll();
		  return new ApiResponse(true,"User fetched SuccessFully",list);
	   } 
	   catch (Exception e) 
	   {
		  return new ApiResponse(false,"Error",e.getMessage());
	   }
   }
}
