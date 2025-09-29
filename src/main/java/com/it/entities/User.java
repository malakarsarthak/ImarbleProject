package com.it.entities;

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
public class User 
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
   
   @OneToOne(mappedBy = "user")
   private Staff staff;
}
