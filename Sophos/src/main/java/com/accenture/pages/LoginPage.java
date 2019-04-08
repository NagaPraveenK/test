package com.accenture.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.accenture.utils.CommonFunctions;
import com.accenture.utils.XLUtils;

public class LoginPage extends CommonFunctions {
	
	XLUtils xl=new XLUtils();
	
	public void openWebPage(String browser, String URL) {
		launchBrowser(browser);
		getUrl(URL);
		
	}
	
	public void logInToPage() throws IOException {
		String username=XLUtils.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet1", 1, 0);
		String password=XLUtils.getStringCellData("C:\\Users\\naga.p.kakanuru\\eclipse-workspace\\Sophos\\src\\Book2.xlsx", "Sheet1", 1, 1);
		sendKeys("id", "sap-user", username);
		sendKeys("id", "sap-password", password);
		//click("id", "LOGON_BUTTON-caption");
		click("xpath", "//*[@class='lsButton lsTbarBtnStd urInlineMetricTop urNoUserSelect urBtnRadius lsButton--design-emphasized urBtnEmph urBtnEmphDB']");
		click("xpath", "//a[contains(text(), '/nwbc')]");
		
	}
	
	public void easyAccess() throws Exception {
		//switchToiFrame("id", "iFrameId_1553602733227");
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//*[contains(@id, 'iFrameId')]")));
		click("xpath", "//ul[@class='sm']/li/a[contains(text(), 'Reservation')]");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'iFrameId')]"))));
		driver.switchTo().frame("ITSFRAME1");
		click("xpath", "//span[@class='urBtnCntTxt']/span/span");
		
	}
	
	public void sproxy() throws AWTException, Exception {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'iFrameId')]"))));
		driver.switchTo().frame("ITSFRAME1");
		Thread.sleep(2000);
		sendKeys("id", "ToolbarOkCode", "sproxy");
		Thread.sleep(2000);
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void lout() {
		driver.switchTo().defaultContent();
		click("xpath", "//a[contains(text(), 'Log Off')]");
		
	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	
}
