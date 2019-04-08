package com.accenture.pages;

public class CreateAccount extends DMPage {
	
	public void goToAcctCreatePage() throws Exception {
		sendKeys("id", "ToolbarOkCode", "/n");
		
		enter();
	
		doubleClick("xpath", "//table[@class='urST5OuterOffBrd urBorderBox']//tr[3]/td//tr/td[3]/div/span");
	}

}
