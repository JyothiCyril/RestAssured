package com.qa.apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TC_001_GET {
	
	@Test
	public void test_01() {
		
		//Response res = RestAssured.get("https://reqres.in/api/users?page=2"); // Url of an 
		
		// replacing the above statement to below as I have done static import of packages
		// refer to the package section
		
		Response res = get("https://reqres.in/api/users?page=2");
		
		
		// Using this we get different type of data
		
		String asString = res.asString();
		System.out.println(asString);
		
		ResponseBody body = res.getBody();
		String asString2 = body.asString();
		System.out.println(asString2);
		
		int statusCode = res.getStatusCode();
		System.out.println(statusCode);
	
		String header = res.getHeader("content-type");
		System.out.println(header);
		
		String statusLine = res.getStatusLine();
		System.out.println(statusLine);
		
		long time = res.getTime();
		System.out.println(time);
		
		
		// we can use regular TestNG asserts as well
		//example: 
		
		Assert.assertEquals(statusCode,"201");
		
		
		
	}
	
	@Test
	public void test_02() {
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200);
		// Auto - assert in rest assured using Given, When, Then format
		
		// negative testing for the above example
		
		//given().get("https://reqres.in/api/users?page=2").then().statusCode(201);
		
		// can also write as below..
		
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]",equalTo(7));
		
		
		
		// Checking if the Id value at the index position is 7 or not
		/*
		 * data --> root element,, id --> attribute, [0] --> index position, 7--> value
		 */
		
	}

}
 