package com.it.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.it.entities.User;
import com.it.models.LoginRequestModel;
import com.it.models.LoginResponseModel;
import com.it.models.RegisterRequestModel;
import com.it.repository.UserRepository;
import com.it.utils.JwtUtils;

@Service
public class UserService
{
   @Autowired
   private UserRepository userRepository;
   
   //Register User
   public boolean registerUser(RegisterRequestModel model)
   {
       try 
       {
    	  //For Mobile Number is same
    	  Optional<User> userExist = userRepository.findByMobile(model.getMobile());
    	  if(userExist.isPresent())
    	  {
    		  return false;
    	  }
    	  
    	  //For New Registration
		  User user = new User();
		  user.setName(model.getName());
		  user.setMobile(model.getMobile());
		  user.setPassword(model.getPassword());
		  user.setRole(model.getRole());
		  user.setStatus(true);
		  
		  userRepository.save(user);
		  return true;
	   } 
       catch (Exception e) 
       {
    	  return false;
	   }
   }
   
   public LoginResponseModel loginUser(LoginRequestModel model)
   {
	   try 
	   {
		   Optional<User> op = userRepository.findByMobileAndPassword(model.getMobile(), model.getPassword());
		   if(op.isPresent())
		   {
			   User user = op.get();
			   String token = JwtUtils.createToken(user.getUserId());
			   
			   return new LoginResponseModel(user.getRole(),token);
		   }
		   else
		   {
			   System.out.println("Login Failed !");
			   return null;
		   }
	   } 
	   catch (Exception e) 
	   {
           System.out.println(e.getMessage());
           return null;
	   }
   }
}
