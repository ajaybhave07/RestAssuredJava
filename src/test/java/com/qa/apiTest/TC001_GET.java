package com.qa.apiTest;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC001_GET {
	
	@Test
	public void getApiCall()
	{
		given()
		.when()
			.get("http://localhost:3000/users")  //  /users is an end point
		
		.then()
		.statusCode(200);
//		.assertThat()
//		.body("firstname", hasItems("anni","bren"))
//		.log().all();
//		
	}

}
