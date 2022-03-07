package com.qa.test;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TC005_Basic_Validation {
	
	
	@Test(priority=1)
	public void testStatusCode()
	{
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/comments?id=1")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	
	@Test(priority=2)
	public void logResponse()
	{
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/comments?email=Nikita@garfield.biz")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test
	public void singleContentTest()
	{
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/comments?email=Nikita@garfield.biz")
		.then()
				.body("postId",equalTo(1));
	}
	
	@Test
	public void allContentTest()
	{
		
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1/comments")
		.then()
			.statusCode(200)
			.body("id", hasItems(1,2,3,4,5)); //verify multiple content from response body
	}
	
	
	@Test
	public void paramHeadersValidation()
	{	
		given()
		.param("name","kevin") //adding parameters to request
		.header("id","22")     // adding headers to request
		.when()
				.get("https://jsonplaceholder.typicode.com/posts?id=2")
		.then()
			.statusCode(200)
			.log().all();
	}
	

}
