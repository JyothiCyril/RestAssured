package com.qa.apitesting;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TC_003_POST {
	
	
	@Test
	public void test_01() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map.put("name", "smith");
		//or
		map.put("\"name\"", "\"smith\"");// to print in JSON format
		map.put("job", "Test Lead");
		
		System.out.println(map);
		
		//Option 1: Using map object
		
		JSONObject req = new JSONObject(map); // can parse map into the object
		System.out.println(req);
		System.out.println(req.toJSONString()); // if printing the req throws any error better to use toJSONString()
		// xml root annotation is missing..
		
		
		
	}
	
	@Test
	public void test_02() {
		
		//Option 2: Without using map object
		//Disclaimer : static imports the Rest Assured libraries
		//url:https://reqres.in/api/users
		// goto reqres app --> select POST --> click the URL generated.
		
		
		JSONObject req2 = new JSONObject(); 
		
		req2.put("name", "Allan");
		req2.put("job", "QA");
		
		System.out.println(req2);
		System.out.println(req2.toJSONString());
		
		
		//given().body(req2.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
				// http status code returns '201' when a new record is created.
				
		
		
		
		// POST request with Header...
		given()
		.header("content-Type" , "application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req2.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);
		
	}

}
