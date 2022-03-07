package com.qa.apiTest;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TC003_DELETE {
	// execute only after post call
	@Test
	public void deleteCall()
	{
		given()
		.when()
			.delete("http://localhost:3000/users/7")
			
		.then()
			.extract().headers();
		
		
		
	}

}
