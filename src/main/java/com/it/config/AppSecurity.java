package com.it.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class AppSecurity
{
   @Autowired
   private AuthFilter authFilter;
   @Bean
   public SecurityFilterChain security(HttpSecurity http) throws Exception
   {
	   http.csrf(ob->ob.disable())
	       .authorizeHttpRequests(req->
	       req.requestMatchers("/users/register","/users/login").permitAll()
	       .anyRequest().authenticated()
	       );
	       http.addFilterBefore(authFilter,UsernamePasswordAuthenticationFilter.class);
	       return http.build();
   }
}
