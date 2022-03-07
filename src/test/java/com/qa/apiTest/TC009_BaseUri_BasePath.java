package com.qa.apiTest;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TC009_BaseUri_BasePath {
	
	@BeforeClass
	public void setUp()
	{
		// to set the uri which is static for all the testcaases
		RestAssured.baseURI="http://localhost:3000";
		RestAssured.basePath="/users";
		
		// here we can define multiple specifications here which are 
		// prerequisites for our api
	}
	
	@Test
	public void getTest()
	{
		given()
		.when()
			.get()
		.then()
			.statusCode(200);
		
	}
	
	@Test
	public void getSpecificValueTest()
	{
		given()
		.when()
			.get("?id=1")
		.then()
			.statusCode(200);
		
	}
}


