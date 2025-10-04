package com.it.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
   //Login from mobile and Password
	Optional<User> findByMobileAndPassword(String mobile, String password);
	
   //Login Only From mobile
	Optional<User> findByMobile(String mobile);
}
