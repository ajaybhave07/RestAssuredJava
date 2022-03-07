package com.qa.test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class TC006_XML_VALIDATION {
	
	
	@Test
	public void xmlResponse()
	{
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
			
		.then()	
			.body("CUSTOMER.ID",equalTo("10"))
			.log().all();
			
		
	}
	
	@Test
	public void multipleResponseValidation()
	{
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
			.body("CUSTOMER.ID", equalTo("10"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
			.body("CUSTOMER.LASTNAME", equalTo("Fuller"))
			.body("CUSTOMER.STREET", equalTo("135 Upland Pl."))
			.log().all();
			
	}
	
	@Test
	public void multipleValidation()
	{
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
			.body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"));
		//verfying entire response
	}
	
	//find values using XML Path in XML Response
	@Test
	public void xmlPathResponse()
	{	
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Sue")));
			
	}

	@Test
	public void xmlPath2()
	{
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/INVOICE")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"));
		
			
	}
}
