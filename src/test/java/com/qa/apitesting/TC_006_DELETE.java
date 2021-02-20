package com.qa.apitesting;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_006_DELETE {

	
	
	@Test
	public void test_01() {
		
		
		// Disclaimer : static imports the Rest Assured libraries
		// url:https://reqres.in/api/users/2
		// goto reqres app --> select DELETE --> click the URL generated.
		
		
	
		when().delete("https://reqres.in/api/users/2")
		.then().statusCode(204).log().all();
		
		// Response code for Delete is 204
		
	}
	
}
