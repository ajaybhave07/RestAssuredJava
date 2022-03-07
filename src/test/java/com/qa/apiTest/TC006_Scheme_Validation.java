package com.qa.apiTest;

import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TC006_Scheme_Validation {
	
	
	
	@Test
	
	public void schemaValidation()
	{
		given()
		.when()
			.get("http://localhost:3000/users/1")
		.then();
	//		.assertThat().body(matchesJsonSchemaInClasspath("src/test/java/com/qa/apiTest/test.json"));
	}
	
	
	@Test
	public void varifyingMany()
	{
		given()
		.when()
			.get("http://localhost:3000/users/")
		.then()
			.body("id", hasItems(1,2,3,4));
		
	
	}
	
	@Test
	public void getListOfValues()
	{
		String res_string=given()
		.when()
			.get("http://localhost:3000/users/")
		.then()
			.extract().asString();
		
		JsonPath jsonPath = new JsonPath(res_string).and().setRoot("");
		List<String> names = jsonPath.get("firstname");
		System.out.println(names);
		
		
		
	
	}
	
	
	

}
