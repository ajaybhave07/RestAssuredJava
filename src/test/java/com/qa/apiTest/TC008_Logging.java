package com.qa.apiTest;



import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TC008_Logging {
	
	
	
	@Test
	public void logTest()
	{
		given()
		.when()
			.get("http://localhost:3000/users/3")
		.then()
	//		.log().headers(); //this will log all the headers to console
	//	    .log().body();   // this will log the body to console
	//		.log().cookies(); // if response has cookies it gets printed	
	//		.log().all(); // to log header,body (entire response)
	//		.log().ifError(); // log if some error comes(if response code is 400 series)
	//		.log().ifStatusCodeIsEqualTo(200);
			.log().body();
			
	}

	
	
	
	
}
