package com.qa.apiTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TC007_Headers_Validation {
	
	
	@Test
	public void getAllHeaders()
	{
	Response response =
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.extract().response();
	
	
		Headers headers=response.getHeaders();
		
		
		for(Header h : headers)
		{
			System.out.println(h.getName()+"---"+h.getValue());
		}
		
	}
	
	@Test
	public void verfiyingHeaders()
	{
	
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.assertThat().header("Connection", "keep-alive") // validating 1 header
			
			//validating multiple headers (passes as  key,value) 
			.assertThat().headers("server","cloudflare",
								  "Content-Encoding","gzip",
								  "Content-Type","application/json; charset=utf-8");
								
	
	}
	
	@Test
	public void verfiyingHeaders1()
	{
	
	Headers headers =given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.assertThat().header("Connection", "keep-alive") // validating 1 header
			
			//validating multiple headers (passes as  key,value) 
		.extract().headers();
	
			System.out.println(headers);					
	
	}
	
	
	

		
}
