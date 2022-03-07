package com.qa.apiTest;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class TC002_GET {

	
		@Test
		public void getApiCall()
		{
			given()
			.when()
				.get("http://localhost:3000/users/1")
			
			.then()
			.statusCode(200)
			.assertThat()
			.body("firstname", equalTo("anni"))
			.assertThat()
			.body("lastname", equalTo("jackson"))
			.assertThat()
			.body("id", equalTo(1));
			
			
			
		}

	}


