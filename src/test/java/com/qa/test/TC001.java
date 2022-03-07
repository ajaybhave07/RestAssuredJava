package com.qa.test;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC001 {

	//get request
	
	@Test
	public void getTest()
	{
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("data.id", equalTo(2))
			.assertThat().body("data.first_name",equalTo("Janet"))
			.header("Content-Type","application/json; charset=utf-8");
	}
}
