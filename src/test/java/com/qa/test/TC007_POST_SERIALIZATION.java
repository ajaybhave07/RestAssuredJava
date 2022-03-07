package com.qa.test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC007_POST_SERIALIZATION {

		//example of post and get request without serialization 
		// here we use hashmap concept
	HashMap<String,String> map;
	
	//@BeforeTest
	public void beforePost()
	{
		map = new HashMap<String,String>();
		map.put("name","john");
		map.put("salary","23440");
		map.put("age", "21");
		
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
		.body("data.name",equalTo("john"))
			.log().all();
			
			
			
	}
	
	@Test
	public void getTest()
	{
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/2")
		.then()
		    .assertThat()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(2));
		
	}
}
