package com.qa.apitesting;

import org.testng.annotations.DataProvider;

public class DataSource {


	@DataProvider
	public Object[][] getDataforPost() {
		return new Object[][] {
			{"Smith","QA"},
			{"Blake","Lead"}
		};
	}


	@DataProvider
	public Object[] getDataforDelete() {
		// single dimension object		
		return new Object[] {
				2,3,4
		};
	}

}
