package com.accenture.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.accenture.pages.CreateAccount;
import com.accenture.pages.DMPage;

public class TC1 extends CreateAccount {
	@BeforeClass
	public void browser() throws Exception {
		openWebPage("chrome", "https://accbnktrg.training.accenture.com:5200/nwbc/~launch/?sap-client=100&sap-language=EN");
		}
	@Test(priority=1)
	public void logiInPage() throws IOException {
		logInToPage();
	}
	
	@Test(priority=2)
	public void sapEasyAccess() throws Exception {
		easyAccess();
		
	}
	
	@Test (priority=3)
	public void busnessPartner() throws Exception {
		clickOnBussinessPartner();
	}
	
	@Test(priority=4)
	public void getBPData() throws IOException, Exception {
		startBP();
		getDataFromBP();
		validateBp();
	}
	
	@Test(priority=5)
	public void logOut() {
		lout();
	}
	
	
	@AfterClass
	public void close() {
		closeBrowser();
	}
	
	
}
