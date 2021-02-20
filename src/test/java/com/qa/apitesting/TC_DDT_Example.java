package com.qa.apitesting;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC_DDT_Example {

	@DataProvider
	public Object[][] getData() {
//		Object[][] data = new Object[3][2];
//		// Name		
//				data[0][0] = "Smith";
//				data[1][0] = "Blake";
//				data[2][0] = "Roger";
//		//Job				
//				data[0][1] = "QA";
//				data[1][1] = "QA Lead";
//				data[2][1] = "QA Manager";
//		
//		return data;

		// or

		return new Object[][] {

				{"Smith","QA"},
				{"Blake","Lead"}
				
		};
	}

	@Test(dataProvider = "getData")
	public void test_01(String ip1, String ip2) {

		JSONObject req = new JSONObject();

		req.put("name", ip1);
		req.put("job",ip2);
			
			  given().body(req.toJSONString()).when()
			  .post("https://reqres.in/api/users") .then().statusCode(201);
			 
		
	}

}
