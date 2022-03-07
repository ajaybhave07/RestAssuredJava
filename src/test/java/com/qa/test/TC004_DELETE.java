package com.qa.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class TC004_DELETE {

	@Test
	public void deleteTest()
	{
		//http://dummy.restapiexample.com/api/v1/delete/2
		String emp_id="2";
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/"+emp_id;
		
		Response response = 
		given()
		.when()
				.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response(); // this line returns Response Object
		
		String body = response.body().asString();
		
		Assert.assertEquals(body.contains("Successfully! Record has been deleted"),true);
		
	}
	
}
