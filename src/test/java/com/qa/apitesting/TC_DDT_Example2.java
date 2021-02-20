package com.qa.apitesting;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_DDT_Example2 {

	@DataProvider
	public Object[][] getDataforPost() {
		return new Object[][] {

			{"Smith","QA"},
			{"Blake","Lead"}

		};
	}

	@Test(dataProvider = "getDataforPost")
	public void test_01(String ip1, String ip2) {

		JSONObject req = new JSONObject();
		req.put("name", ip1);
		req.put("job",ip2);

		given().body(req.toJSONString()).when()
		.post("https://reqres.in/api/users") .then().statusCode(201);
	}
	
	@DataProvider
	public Object[] getDataforDelete() {
		// single dimension object
		
		return new Object[] {
				2,3,4
		};
	}
 
	@Test(dataProvider="getDataforDelete")
	public void test_02(int input) {

		when().delete("https://reqres.in/api/users/"+input)
		.then().statusCode(204).log().all();

	}

}
