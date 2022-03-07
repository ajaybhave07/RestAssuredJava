package com.qa.test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
public class TC008_Serialization_Deserialization {

	
	
	@Test
	public void postRequest()
	{
		Employee e1 = new Employee();
		e1.setId(7);
		e1.setFirstname("sneha");
		e1.setLastname("mehra");
		e1.setLocation("pune");
		
		RestAssured.baseURI="http://localhost:3000/";
		RestAssured.basePath="users/";  // path parameter
		
		
		given()
			.contentType(ContentType.JSON) // similar to "application/json"
			.body(e1)
		.when()
			.post()
		.then()
			.statusCode(201)
			.log()
			.body(); // just log the body not entire response
		}
	
	@Test
	public void getRequest() 
	{
		Employee e1 = given().when().get("http://localhost:3000/users/7").as(Employee.class);
		System.out.println(e1.id);
		System.out.println(e1.firstname);
		System.out.println(e1.lastname);
		System.out.println(e1.location);
	}
	
}
