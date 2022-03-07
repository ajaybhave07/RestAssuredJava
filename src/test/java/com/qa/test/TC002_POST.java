package com.qa.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC002_POST {
	
	static HashMap<String,String> map;
	
	@BeforeClass
	public void postData()
	{
		map = new HashMap<String,String>();
		map.put("name", "nitin");
		map.put("salary", "34000");
		map.put("age", "23");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/create";
	}
	@Test
	public void postTest()
	{
		given()
			.contentType("application/json")
			.body(map)
	
		
		.when()
			.post()
		
		.then()
			.statusCode(200)
			.and()
			.body("status", equalTo("success"))
			.and()
			.body("data.name",equalTo("nitin"));
		
			
	}

}
