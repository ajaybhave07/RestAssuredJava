package com.qa.apiTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TC001_POST {

	
	@Test
	public void postApiTest()
	{
		
		// we can use both hashmap or json object
		JSONObject request = new JSONObject();
		request.put("id", 1);
		request.put("firstname", "tbone");
		request.put("lastname","rai");
		request.put("location", "banglore");
		
		
		given()
			.contentType("application/json")
			.body(request.toJSONString())
		
		.when()
		.put("http://localhost:3000/users/7")
		.then()
		.statusCode(200)
		.log().all();
		
	}
}
