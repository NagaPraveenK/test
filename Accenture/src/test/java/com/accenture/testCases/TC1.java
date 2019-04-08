package com.accenture.testCases;

import org.testng.annotations.Test;

import com.accenture.Pages.LoginPage;

public class TC1 extends LoginPage {
	@Test
	public void loginPage() throws Exception {
		login("naga.p.kakanuru@accenture.com");
		addItem();
	}
	
	
}
