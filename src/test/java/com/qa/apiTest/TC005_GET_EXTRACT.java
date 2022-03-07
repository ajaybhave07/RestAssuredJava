package com.qa.apiTest;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TC005_GET_EXTRACT {
	
	
	@Test
	public void extractPathTest()
	{
		String location = given()
		.when()
			.get("http://localhost:3000/users/1")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.extract().path("location");   //very useful
		
		// to extract a perticular key's value
		
		System.out.println(location);
		
		
		// we can fetch uri from a response as a string , and then again
		//execute a get call on that 
		//example:
		
		// String url = get("https://www.jsonplaceholder.com/1").andReturn()
		// .jsonPath().getString("thumbnailuri");
		
		//given().when().get(url).statusCode(200);
		
	}
	
	
	@Test
	public void extractResponseTest()
	{
		
		Response response = given()
		.when()
			.get("http://localhost:3000/users/1")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.extract().response();
		
		System.out.println(response.body().asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
	}
	
	
	
	@Test
	public void extractResponseBody()
	{
		
    String body =	

		given()
		.when()
			.get("http://localhost:3000/users/1")
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.extract().body().asString();


	System.out.println(body);
	}


}
