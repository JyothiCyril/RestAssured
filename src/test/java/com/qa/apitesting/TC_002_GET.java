package com.qa.apitesting;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_002_GET {
	
	
	@Test
	public void test_01() {
		
		
		/*
		 * given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
		 * .log().all();
		 */
		// Simple example for GET request
		// that also logs all the response in the console --> log().all();
	
		given().get("https://reqres.in/api/users?page=2").then()
			.statusCode(200)
			.body("data.id[1]", equalTo(8))
			.log().all();
		
		//  example for validating the multiple response
		given().get("https://reqres.in/api/users?page=2").then()
		.statusCode(200)
		.body("data.id[1]", equalTo(8))
		.body("data.first_name", hasItems("Michael","Lindsay"));
		
	}

}
