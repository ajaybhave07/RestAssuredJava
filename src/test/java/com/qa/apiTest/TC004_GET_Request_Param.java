package com.qa.apiTest;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class TC004_GET_Request_Param {
	
	
	@Test
	public void getParamTest()
	{
		given()
			
			.param("firstname", "Bren") //these are query parameters
			.header("head1","head2") // dummy data - for demo
		.when()
				.get("http://localhost:3000/users/")
		.then()                      // validation all the response body
				.statusCode(200)
				
				.body("[0].location",equalTo("miami"))
				.and()
				.body("[0].firstname", equalTo("Bren"))
				.and()
				.body("[0].lastname", equalTo("Callingwood"))
				.and()
				.body("[0].id", equalTo(2))
				.log().body();
			
			
	}
	
	
	

}
