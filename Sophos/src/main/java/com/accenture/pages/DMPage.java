package com.accenture.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.accenture.utils.XLUtils;

public class DMPage extends LoginPage {

	public void clickOnBussinessPartner() throws Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'iFrameId')]"))));
		driver.switchTo().frame("ITSFRAME1");
		click("xpath", "//td[@id='tree#6.105#0000000033#0']/table/tbody/tr/td/img");
		Thread.sleep(2000);
		click("xpath", "//*[@id='tree#6.105-mrss-cont-none-content']//tr[11]/td/table[1]/tbody/tr/td/img");
		Thread.sleep(2000);
		doubleClick("xpath", "//*[@id='tree#6.105-mrss-cont-none']//tr[12]//td[3]//td[3]/div/span");
			}
	
	public void startBP() {
		clear("xpath", "//div[@class='urTbsWhl pstabp urBorderBox']//input[@title='Business Partner Number']");
		click("xpath", "//span[contains(text(), 'Start')]");
		
	}
	
	public void getDataFromBP() throws IOException, Exception {
		Thread.sleep(3000);
		
		int rc=rowCount("xpath", "//td[@class='lsCnArFaceTrans lsCnArBrdNone lsPnCntPadNone']/table[1]/tbody/tr[2]/td/div/div/table/tbody/tr");
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			String partner=objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='lsCnArFaceTrans lsCnArBrdNone lsPnCntPadNone']/table[1]/tbody/tr[2]/td/div/div/table/tbody/tr["+i+"]/td[1]/div/span/input"))).getAttribute("value");
			String description=objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='lsCnArFaceTrans lsCnArBrdNone lsPnCntPadNone']/table[1]/tbody/tr[2]/td/div/div/table/tbody/tr["+i+"]/td[2]/div/span/input"))).getAttribute("value");
			
		//	System.out.println(partner + " :" +i+": "+description );
			XLUtils.setCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet2", i, 0, partner);
			//XLUtils.setCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet3", i, 2, description);
			
		}
		
		for(int i=1;i<=rc;i++)
		{
			String partner=objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='lsCnArFaceTrans lsCnArBrdNone lsPnCntPadNone']/table[1]/tbody/tr[2]/td/div/div/table/tbody/tr["+i+"]/td[1]/div/span/input"))).getAttribute("value");
			String description=objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='lsCnArFaceTrans lsCnArBrdNone lsPnCntPadNone']/table[1]/tbody/tr[2]/td/div/div/table/tbody/tr["+i+"]/td[2]/div/span/input"))).getAttribute("value");
			
		//	System.out.println(partner + " :" +i+": "+description );
			//XLUtils.setCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet3", i, 1, partner);
			XLUtils.setCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet3", i, 1, description);
			
		}
	
	
	
	
	
	}
	public void validateBp() throws IOException, Exception {
		String BP=XLUtils.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet2", 5, 0);
				
		sendKeys("xpath", "//div[@class='urTbsWhl pstabp urBorderBox']//input[@title='Business Partner Number']", BP);
		click("xpath", "//span[contains(text(), 'Start')]");
		Thread.sleep(2500);
		doubleClick("xpath", "//table[@class='urST5OuterOffBrd urBorderBox']/tbody/tr[1]/td[1]/div/span[1]/input");
	}
	
}
