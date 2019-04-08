package com.accenture.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions extends BrowserUtils {
	public static WebDriverWait objwait;
	Select select;
	Actions act;
	Robot rt;
	
	
	public WebElement findElement(String identifier, String locator)
	{
		WebElement e = null;
		objwait=new WebDriverWait(driver, 20);
		
		switch(identifier)
		{
		case "name" :
			e=objwait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			break;
			
		case "id":
			e=objwait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			break;
			
		case "linktext" :
			e=objwait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
			break;
			
		case "xpath" :
			e=objwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			break;
			
		default :
			System.out.println("Unable to find Identifier & Locator");
		}
		return e;
	}
	
	public void sendKeys(String identifier, String locator, String text)
	{
		WebElement e=findElement(identifier, locator);
		e.sendKeys(text);
	}

	public void click(String identifier, String locator)
	{
		WebElement e=findElement(identifier, locator);
		e.click();
	}
	
	public String getText(String identifier, String locator)
	{
		String text=null;
		WebElement e=findElement(identifier, locator);
		text=e.getText();
		return text;
	}
	
	public boolean presenceOfElement(String identifier, String locator) {
		WebElement e=findElement(identifier, locator);
		if(e.isDisplayed()) {
		return true;
		}
		else {
			return false;
		}
	}
	
	public void select(String identifier, String locator, String selectmethod, String text)
	{
		WebElement e=findElement(identifier, locator);
		select=new Select(e);
		
		if(selectmethod.equals("visibletext")){
			select.selectByVisibleText(text);
		}
		else if(selectmethod.equals("value")) {
			select.selectByValue(text);
		}
		else if(selectmethod.equals("index")){
			int id=Integer.parseInt(text);
			select.selectByIndex(id);
		}
		
	}
	
	public void switchToiFrame(String identifier, String text) {
		switch(identifier)
		{
		case "name" :
			driver.switchTo().frame(text);
			break;
			
		case "id" :
			driver.switchTo().frame(text);
			break;
			
		case "index" :
			driver.switchTo().frame(text);
			break;
			
		default :
			System.out.println("Wrong input");
		}
	}
	
	public void doubleClick(String identifier, String locator) {
		WebElement e=findElement(identifier, locator);
		act=new Actions(driver);
		act.doubleClick(e).perform();
	}
	
	public List<WebElement> findElements(String identifier, String locator)
	{
		List<WebElement> e = null;
		objwait=new WebDriverWait(driver, 20);
		
		switch(identifier)
		{
		case "name" :
			e=objwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(locator)));
			break;
			
		case "id":
			e=objwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
			break;
			
		case "linktext" :
			e=objwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(locator)));
			break;
			
		case "xpath" :
			e=objwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
			break;
			
		default :
			System.out.println("Unable to find Identifier & Locator");
		}
		return e;
	}
	
	public int rowCount(String identifier, String locator) {
		
		int rc=findElements(identifier, locator).size();
		return rc;
		
	}
	
	public void enter() throws Exception {
		Thread.sleep(1500);
		rt=new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void clear(String identifier, String locator) {
		WebElement e=findElement(identifier, locator);
		e.clear();
		
	}
	
	
}
