package com.qa.apitesting;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_005_PATCH {

	
	
	@Test
	public void test_01() {
		
		
		// Disclaimer : static imports the Rest Assured libraries
		// url:https://reqres.in/api/users/2
		// goto reqres app --> select PATCH --> click the URL generated.
		
		
		JSONObject req2 = new JSONObject(); 
		
		req2.put("name", "Jones");
		req2.put("job", "QA");
		
		System.out.println(req2);
		System.out.println(req2.toJSONString());
		
		
		 given().body(req2.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200);
		// http status code returns '200' when a  record is updated.
				
		
		
		
		// PUT request with Header...
		given()
		.header("content-Type" , "application/json") 
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON) // accept only of the format is JSON
		.body(req2.toJSONString()).when().patch("https://reqres.in/api/users")
		.then().statusCode(200)
		.log().all();// to log all the status
		
	}
	
}
