package com.qa.apiTest;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TC001_PUT {
	
	@Test
	public void putCallTest()
	{	
		// do not execute again , working fine
		
		JSONObject payload = new JSONObject();
		payload.put("id", 2);
		payload.put("firstname", "Bren");
		payload.put("lastname", "callingwood");
		payload.put("location", "miami");

		
		
		given()
		   
			.contentType("application/json")
			.body(payload.toJSONString())
		.when()
			.put("http://localhost:3000/users/2")
		.then()
			.log().body();
			
			
	
	}
	
	
}	
