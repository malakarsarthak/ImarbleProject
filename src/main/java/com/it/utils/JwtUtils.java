package com.it.utils;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils
{
	private static final String SECRET_KEY= "14930665748bbc241f255a6b34ae325a1f5b08527152f6f38b36a817a40bca30"
			+ "14930665748bbc241f255a6b34ae325a1f5b08527152f6f38b36a817a40bca301493066574"
			+ "8bbc241f255a6b34ae325a1f5b08527152f6f38b36a817a40bca3014930665748bbc"
			+ "241f255a6b34ae325a1f5b08527152f6f38b36a817a40bca30";
	
	private  static final int limit = 1000*60*10;
		
	public static String createToken(Integer userId) 
	{
		 String token = Jwts.builder()
         .setSubject(userId+"")
         .setIssuedAt(new Date())
         .setExpiration(new Date(System.currentTimeMillis() + limit))
         .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
         .compact();
		return token;
	}
	
	public static String getData(String token) 
	{
		Claims clm = extractAllClaims(token);
		return clm.getSubject();
	}
	
	public static boolean isvalid(String token)
	{
		Claims clm = extractAllClaims(token);
		return !clm.getExpiration().before(new Date());
	}
	
	private static Claims extractAllClaims(String token) 
	{
	    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	} 

}
