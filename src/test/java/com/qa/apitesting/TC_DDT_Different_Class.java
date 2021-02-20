package com.qa.apitesting;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_DDT_Different_Class extends DataSource{

	@Test(dataProvider = "getDataforPost")
	public void test_01(String ip1, String ip2) {

		JSONObject req = new JSONObject();
		req.put("name", ip1);
		req.put("job",ip2);

		given().body(req.toJSONString()).when()
		.post("https://reqres.in/api/users") .then().statusCode(201);
	}


	@Test(dataProvider="getDataforDelete")
	public void test_02(int input) {

		when().delete("https://reqres.in/api/users/"+input)
		.then().statusCode(204).log().all();

	}

}
