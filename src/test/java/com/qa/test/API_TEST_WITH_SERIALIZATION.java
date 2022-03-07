package com.qa.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class API_TEST_WITH_SERIALIZATION {
	
	// do not execute the code it is just demo
	// here rather then sending the map object we will send the class object
	@Test(priority=1)
	public void createNewStudent()
	{
		Student s1 = new Student();
		s1.setId(12);
		s1.setName("naina");
		//serialization
		given()
			.contentType("application.json")
			.body(s1)
		.when()
			.post()
		.then()
			.statusCode(200)
			.assertThat()
			.body("msg", equalTo("Student addes"));
		
		}
	
	@Test
	void getStudentRecord()
	{
		//de serialization
		Student s1 = given().when().get("url").as(Student.class);
		System.out.println(s1.firstName+"  "+s1.getId());
		
		
		
	}

}


