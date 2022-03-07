package com.qa.test;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class TC003_PUT {

	
	static HashMap<String,String> map;
	//	http://dummy.restapiexample.com/api/v1/update/21
	@BeforeClass
	public void putData()
	{
		map = new HashMap<String,String>();
		map.put("name", "gagan");
		map.put("salary", "23000");
		map.put("age", "23");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/21";
	}
	
	
	@Test
	public void putTest()
	{
		given().
			contentType("application/json")
			.body(map)
			
		.when()
			.put()
		
		.then()
			.statusCode(200)
			.log().all()
			.body("data.name", equalTo("gagan"));
			
			
		
		
	}
	
	
	
	
	
	
}
