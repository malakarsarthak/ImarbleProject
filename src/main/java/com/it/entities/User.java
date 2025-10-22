package com.it.entities;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements UserDetails
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="UserId")
   private Integer userId;
   
   @Column(name = "Name", nullable = false)
   private String name;
   
   @Column(name = "Mobile", nullable = false, unique = true)
   private String mobile;
   
   @Column(name = "Password", nullable = false)
   private String  password;
   
   @Column(name = "Role", nullable = false)
   private String role;
   
   @Column(name = "Status", nullable = false)
   private boolean status;
   
   @OneToOne(mappedBy = "userId")
   private Staff staff;

   public Collection<? extends GrantedAuthority> getAuthorities() 
   {
	 return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role));
   }

   @Override
   public String getUsername() 
   {
	 return mobile;
   }
   	
   @Override
   public boolean isAccountNonExpired() 
   {
       return true; 
   }

   @Override
   public boolean isAccountNonLocked() 
   {
       return true; 
   }

   @Override
   public boolean isCredentialsNonExpired() 
   {
       return true; 
   }

   @Override
   public boolean isEnabled() 
   {
       return status; 
   }
}
